package com.zheshuo.advert.core.easyexcel;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ZhangLong on 2019/11/4  10:25 上午
 * @version V1.0
 */
@Data
public class ExportSheetDetail<Export extends AbstractExcelModel, Source> {

    public ExportSheetDetail(){
        validatedAndInit();
    }

    public ExportSheetDetail(
        @NotNull(message = "model类类型不能为空") Class<Export> mClass,
        @NotEmpty(message = "导出数据不能为空") List<Source> data, String sheetName,
        Integer headRowNumber, Integer sheetNo ) {
        this.mClass = mClass;
        this.data = data;
        this.sheetName = sheetName;
        this.headRowNumber = headRowNumber;
        this.sheetNo = sheetNo;
        validatedAndInit();
    }

    @NotNull(message = "model类类型不能为空")
    private Class<Export> mClass;
    @NotEmpty(message = "导出数据不能为空")
    private List<Source> data;

    private String sheetName = "sheet";
    /**
     * description 默认为1从第一行开始
     */
    private Integer headRowNumber = 1;
    /**
     * description 从0开始
     */
    private Integer sheetNo = 0;

    public void validatedAndInit() {
        if (Objects.isNull(headRowNumber) || headRowNumber < 1) {
            headRowNumber = 1;
        }

        if (Objects.isNull(sheetNo) || sheetNo < 0) {
            sheetNo = 0;
        }

        if (StringUtils.isBlank(sheetName)) {
            sheetName = "sheet" + sheetNo;
        }

    }
}
