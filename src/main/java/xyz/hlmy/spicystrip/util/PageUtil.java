package xyz.hlmy.spicystrip.util;

import xyz.hlmy.spicystrip.model.actviti.dto.PageInfoDto;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    public static <T> List<T> getPageData(PageInfoDto pageInfoDto, List<T> data) {
        List<T> dataList = new ArrayList<>();

        if (pageInfoDto == null || data.size() == 0 || data == null) {
            return data;
        }
        int pageIndex = pageInfoDto.getIndex();
        int limit = pageInfoDto.getPageSize();
        // 是否超页
        int maxCount = (pageIndex + 1) * limit;
        if (maxCount > data.size() && (maxCount - data.size()) > limit) {
            return dataList;
        }
        int start = (pageIndex) * limit; // 起始位置
        int end = (pageIndex + 1) * limit;// 结束位置
        for (int i = start; i < end; i++) {
            if (data.size() > i) {
                dataList.add(data.get(i));
            }
        }
        return dataList;
    }
}
