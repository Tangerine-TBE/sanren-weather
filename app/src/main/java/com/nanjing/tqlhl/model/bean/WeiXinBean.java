package com.nanjing.tqlhl.model.bean;

public class WeiXinBean {

    /**
     * access_token : 35_ZyUhtkIChejZP2CaKSccP0Hl66HQ51krIif9HGJfbuHfSqxrqPDRXJ3AWb3UcJkFqMr2RfE1Ze9Sdw81KTsFxP6pDhX_7xV3a_MN3BEax7E
     * expires_in : 7200
     * refresh_token : 35_p8x-XDUeW6wSO0Mh-S-_s0JGqQpc56-4aBKYV1NltnCMbzA2RtLBhRd25MFeYPMbabhNtsMHOLWGyy35JpQYAtQFM0eo-COAuoC3DTRdgWE
     * openid : oAfqXs16SPvdVzsIaYDxaI5GwWyw
     * scope : snsapi_userinfo
     * unionid : o99SAwSc5K7Lx9-zlhkYNMBuapRc
     */

    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
