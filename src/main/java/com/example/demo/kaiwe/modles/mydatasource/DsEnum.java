package com.example.demo.kaiwe.modles.mydatasource;

/**
 * @author: liangjinyin
 * @Date: 2018-11-01
 * @Description:
 */
public enum DsEnum {
    /**
     * 数据库枚举
     */
    GZ_DS("gz","200","广州数据库"),
    SZ_DS("sz","300","深圳数据库"),
    AUTO_DS("auto","000","按照CITYID获取数据库"),
    NONE("error","999","CID ERROR")
    ;

    private String ds;
    private String cid;
    private String message;

    public static DsEnum createDSByCid(String cid) {
        for(DsEnum val : DsEnum.values()) {
            if(val.getCid().equalsIgnoreCase(cid)) {
                return val;
            }
        }
        return DsEnum.NONE;
    }

    DsEnum(String ds, String cid) {
        this.ds = ds;
        this.cid = cid;
    }

    DsEnum(String ds, String cid, String message) {
        this.ds = ds;
        this.cid = cid;
        this.message = message;
    }

    public String getDs() {
        return ds;
    }

    public String getCid() {
        return cid;
    }

    public String getMessage() {
        return message;
    }


}
