package cn.miven.cloud.center.info;

import com.netflix.appinfo.DataCenterInfo;

import static com.netflix.appinfo.DataCenterInfo.Name.Netflix;

/**
 * @author mingzhi.xie
 * @date 2020/4/25
 * @since 1.0
 */
public class ShanghaiDataCenterInfo implements DataCenterInfo {

    @Override
    public Name getName() {
        return Netflix;
    }
}
