package com.zheshuo.advert.core.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.MapperKey;
import ma.glasnost.orika.metadata.TypeFactory;
import org.apache.poi.ss.formula.functions.T;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class Mapper {

    private Mapper() {
    }

    private static final MapperFactory mapperFactory;

    private static final Object CLASS_MAP_REGISTER_LOCK = new Object();

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public static <T, S> List<T> map(List<S> source, Class<T> target) {
        Objects.requireNonNull(source, "source must be not null");

        List<T> list = new ArrayList<>(source.size());

        for (Object o : source) {
            T result = map(o, target);

            list.add(result);
        }

        return list;
    }

    public static <T, S> T map(S source, Class<T> target) {
        Objects.requireNonNull(source, "source must be not null");
        MapperSource mapperSource = target.getAnnotation(MapperSource.class);
        Class<?> sourceClass;
        if (mapperSource == null) {
            sourceClass = source.getClass();
        } else {
            sourceClass = mapperSource.value();
        }

        MapperKey mapperKey = getMapperKey(target, sourceClass);
        if (mapperFactory.getClassMap(mapperKey) == null) {
            synchronized (CLASS_MAP_REGISTER_LOCK) {
                if (mapperFactory.getClassMap(mapperKey) == null) {
                    registerClassMap(target, sourceClass);
                }
            }
        }
        BoundMapperFacade mapperFacade = mapperFactory.getMapperFacade(sourceClass, target);
        return (T) mapperFacade.map(source);
    }

    private static <T, S>  MapperKey getMapperKey(Class<T> tc, Class<S> sc) {
        return new MapperKey(TypeFactory.valueOf(sc), TypeFactory.valueOf(tc));
    }

    private static <T, S> void registerClassMap(Class<T> tc, Class<S> sc) {
        ClassMapBuilder classMapBuilder = mapperFactory.classMap(sc, tc);

        Field[] fields = tc.getDeclaredFields();
        for (Field field : fields) {
            MapperProperty mapperProperty = field.getAnnotation(MapperProperty.class);
            if (mapperProperty == null) {
                continue;
            }

            for (String el : mapperProperty.value()) {
                if (findField(sc, el) == null) {
                    continue;
                }

                classMapBuilder.field(el, field.getName());
            }
        }

        classMapBuilder.byDefault().register();
    }

    private static <S> Field findField(Class<S> clazz, String fieldName) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        return null;
    }
}
