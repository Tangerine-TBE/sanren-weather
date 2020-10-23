package com.nanjing.tqlhl.model.bean;

/**
 * @author: Administrator
 * @date: 2020/7/4 0004
 */
public class AddressBean {
    @Override
    public String toString() {
        return "AddressBean{" +
                "status=" + status +
                ", result=" + result +
                '}';
    }

    /**
     * status : 0
     * result : {"location":{"lng":104.08153351042463,"lat":30.655821878416408},"precise":0,"confidence":20,"comprehension":100,"level":"城市"}
     */

    private int status;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "location=" + location +
                    ", precise=" + precise +
                    ", confidence=" + confidence +
                    ", comprehension=" + comprehension +
                    ", level='" + level + '\'' +
                    '}';
        }

        /**
         * location : {"lng":104.08153351042463,"lat":30.655821878416408}
         * precise : 0
         * confidence : 20
         * comprehension : 100
         * level : 城市
         */



        private LocationBean location;
        private int precise;
        private int confidence;
        private int comprehension;
        private String level;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public int getPrecise() {
            return precise;
        }

        public void setPrecise(int precise) {
            this.precise = precise;
        }

        public int getConfidence() {
            return confidence;
        }

        public void setConfidence(int confidence) {
            this.confidence = confidence;
        }

        public int getComprehension() {
            return comprehension;
        }

        public void setComprehension(int comprehension) {
            this.comprehension = comprehension;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public static class LocationBean {
            /**
             * lng : 104.08153351042463
             * lat : 30.655821878416408
             */

            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }
    }
}
