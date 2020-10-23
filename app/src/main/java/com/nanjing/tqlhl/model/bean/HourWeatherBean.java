package com.nanjing.tqlhl.model.bean;

import java.util.List;

public class HourWeatherBean {

    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Taipei
     * server_time : 1594000580
     * location : [25.1552,121.6544]
     * result : {"hourly":{"status":"ok","description":"未来24小时阴","precipitation":[{"datetime":"2020-07-06T09:00+08:00","value":0},{"datetime":"2020-07-06T10:00+08:00","value":0},{"datetime":"2020-07-06T11:00+08:00","value":0},{"datetime":"2020-07-06T12:00+08:00","value":0},{"datetime":"2020-07-06T13:00+08:00","value":0},{"datetime":"2020-07-06T14:00+08:00","value":0},{"datetime":"2020-07-06T15:00+08:00","value":0},{"datetime":"2020-07-06T16:00+08:00","value":0},{"datetime":"2020-07-06T17:00+08:00","value":0},{"datetime":"2020-07-06T18:00+08:00","value":0},{"datetime":"2020-07-06T19:00+08:00","value":0},{"datetime":"2020-07-06T20:00+08:00","value":0},{"datetime":"2020-07-06T21:00+08:00","value":0},{"datetime":"2020-07-06T22:00+08:00","value":0},{"datetime":"2020-07-06T23:00+08:00","value":0},{"datetime":"2020-07-07T00:00+08:00","value":0},{"datetime":"2020-07-07T01:00+08:00","value":0},{"datetime":"2020-07-07T02:00+08:00","value":0},{"datetime":"2020-07-07T03:00+08:00","value":0},{"datetime":"2020-07-07T04:00+08:00","value":0},{"datetime":"2020-07-07T05:00+08:00","value":0},{"datetime":"2020-07-07T06:00+08:00","value":0},{"datetime":"2020-07-07T07:00+08:00","value":0},{"datetime":"2020-07-07T08:00+08:00","value":0},{"datetime":"2020-07-07T09:00+08:00","value":0},{"datetime":"2020-07-07T10:00+08:00","value":0},{"datetime":"2020-07-07T11:00+08:00","value":0},{"datetime":"2020-07-07T12:00+08:00","value":0},{"datetime":"2020-07-07T13:00+08:00","value":1.1582},{"datetime":"2020-07-07T14:00+08:00","value":0.1393},{"datetime":"2020-07-07T15:00+08:00","value":0.2389},{"datetime":"2020-07-07T16:00+08:00","value":0},{"datetime":"2020-07-07T17:00+08:00","value":5.2516},{"datetime":"2020-07-07T18:00+08:00","value":0.9416},{"datetime":"2020-07-07T19:00+08:00","value":0},{"datetime":"2020-07-07T20:00+08:00","value":0},{"datetime":"2020-07-07T21:00+08:00","value":0},{"datetime":"2020-07-07T22:00+08:00","value":0},{"datetime":"2020-07-07T23:00+08:00","value":0},{"datetime":"2020-07-08T00:00+08:00","value":0},{"datetime":"2020-07-08T01:00+08:00","value":0},{"datetime":"2020-07-08T02:00+08:00","value":0},{"datetime":"2020-07-08T03:00+08:00","value":0},{"datetime":"2020-07-08T04:00+08:00","value":0},{"datetime":"2020-07-08T05:00+08:00","value":0},{"datetime":"2020-07-08T06:00+08:00","value":0},{"datetime":"2020-07-08T07:00+08:00","value":0},{"datetime":"2020-07-08T08:00+08:00","value":0}],"temperature":[{"datetime":"2020-07-06T09:00+08:00","value":30.16},{"datetime":"2020-07-06T10:00+08:00","value":30.97},{"datetime":"2020-07-06T11:00+08:00","value":30.77},{"datetime":"2020-07-06T12:00+08:00","value":30.58},{"datetime":"2020-07-06T13:00+08:00","value":31},{"datetime":"2020-07-06T14:00+08:00","value":31},{"datetime":"2020-07-06T15:00+08:00","value":30},{"datetime":"2020-07-06T16:00+08:00","value":30},{"datetime":"2020-07-06T17:00+08:00","value":29},{"datetime":"2020-07-06T18:00+08:00","value":28.7},{"datetime":"2020-07-06T19:00+08:00","value":27.6},{"datetime":"2020-07-06T20:00+08:00","value":27.4},{"datetime":"2020-07-06T21:00+08:00","value":26.6},{"datetime":"2020-07-06T22:00+08:00","value":26.5},{"datetime":"2020-07-06T23:00+08:00","value":26.4},{"datetime":"2020-07-07T00:00+08:00","value":26.3},{"datetime":"2020-07-07T01:00+08:00","value":26.2},{"datetime":"2020-07-07T02:00+08:00","value":26.5},{"datetime":"2020-07-07T03:00+08:00","value":26},{"datetime":"2020-07-07T04:00+08:00","value":27.5},{"datetime":"2020-07-07T05:00+08:00","value":28},{"datetime":"2020-07-07T06:00+08:00","value":28.3},{"datetime":"2020-07-07T07:00+08:00","value":28.6},{"datetime":"2020-07-07T08:00+08:00","value":29.1},{"datetime":"2020-07-07T09:00+08:00","value":29.12},{"datetime":"2020-07-07T10:00+08:00","value":29.44},{"datetime":"2020-07-07T11:00+08:00","value":31},{"datetime":"2020-07-07T12:00+08:00","value":30.5},{"datetime":"2020-07-07T13:00+08:00","value":31},{"datetime":"2020-07-07T14:00+08:00","value":31},{"datetime":"2020-07-07T15:00+08:00","value":30.92},{"datetime":"2020-07-07T16:00+08:00","value":30.74},{"datetime":"2020-07-07T17:00+08:00","value":30.47},{"datetime":"2020-07-07T18:00+08:00","value":30.02},{"datetime":"2020-07-07T19:00+08:00","value":29.31},{"datetime":"2020-07-07T20:00+08:00","value":28.64},{"datetime":"2020-07-07T21:00+08:00","value":28.04},{"datetime":"2020-07-07T22:00+08:00","value":27.69},{"datetime":"2020-07-07T23:00+08:00","value":27.26},{"datetime":"2020-07-08T00:00+08:00","value":27.03},{"datetime":"2020-07-08T01:00+08:00","value":26.78},{"datetime":"2020-07-08T02:00+08:00","value":26.55},{"datetime":"2020-07-08T03:00+08:00","value":26.68},{"datetime":"2020-07-08T04:00+08:00","value":26.83},{"datetime":"2020-07-08T05:00+08:00","value":26},{"datetime":"2020-07-08T06:00+08:00","value":27.45},{"datetime":"2020-07-08T07:00+08:00","value":27.8},{"datetime":"2020-07-08T08:00+08:00","value":28.12}],"wind":[{"datetime":"2020-07-06T09:00+08:00","speed":27.72,"direction":220},{"datetime":"2020-07-06T10:00+08:00","speed":2.88,"direction":273.62},{"datetime":"2020-07-06T11:00+08:00","speed":2.42,"direction":224.64},{"datetime":"2020-07-06T12:00+08:00","speed":1.11,"direction":236.15},{"datetime":"2020-07-06T13:00+08:00","speed":2.04,"direction":159},{"datetime":"2020-07-06T14:00+08:00","speed":4.32,"direction":110.5},{"datetime":"2020-07-06T15:00+08:00","speed":5.68,"direction":139.36},{"datetime":"2020-07-06T16:00+08:00","speed":1.94,"direction":178.26},{"datetime":"2020-07-06T17:00+08:00","speed":0.49,"direction":160.55},{"datetime":"2020-07-06T18:00+08:00","speed":1.01,"direction":20.17},{"datetime":"2020-07-06T19:00+08:00","speed":0.33,"direction":47.68},{"datetime":"2020-07-06T20:00+08:00","speed":1,"direction":235.32},{"datetime":"2020-07-06T21:00+08:00","speed":1.23,"direction":205.24},{"datetime":"2020-07-06T22:00+08:00","speed":2.75,"direction":160.72},{"datetime":"2020-07-06T23:00+08:00","speed":3.32,"direction":161.07},{"datetime":"2020-07-07T00:00+08:00","speed":3.19,"direction":241.98},{"datetime":"2020-07-07T01:00+08:00","speed":6.57,"direction":284.5},{"datetime":"2020-07-07T02:00+08:00","speed":6.14,"direction":271.19},{"datetime":"2020-07-07T03:00+08:00","speed":6.52,"direction":248.05},{"datetime":"2020-07-07T04:00+08:00","speed":7.26,"direction":226.23},{"datetime":"2020-07-07T05:00+08:00","speed":5.41,"direction":206.36},{"datetime":"2020-07-07T06:00+08:00","speed":3.12,"direction":210.7},{"datetime":"2020-07-07T07:00+08:00","speed":3.24,"direction":206.76},{"datetime":"2020-07-07T08:00+08:00","speed":3.41,"direction":202.98},{"datetime":"2020-07-07T09:00+08:00","speed":2.4,"direction":223.65},{"datetime":"2020-07-07T10:00+08:00","speed":2.77,"direction":297.79},{"datetime":"2020-07-07T11:00+08:00","speed":2.42,"direction":279.24},{"datetime":"2020-07-07T12:00+08:00","speed":4.27,"direction":307.68},{"datetime":"2020-07-07T13:00+08:00","speed":5.87,"direction":281.4},{"datetime":"2020-07-07T14:00+08:00","speed":7.14,"direction":254.24},{"datetime":"2020-07-07T15:00+08:00","speed":6.29,"direction":247.52},{"datetime":"2020-07-07T16:00+08:00","speed":4.51,"direction":231.76},{"datetime":"2020-07-07T17:00+08:00","speed":2.72,"direction":196.75},{"datetime":"2020-07-07T18:00+08:00","speed":4.72,"direction":177.88},{"datetime":"2020-07-07T19:00+08:00","speed":3.38,"direction":200.46},{"datetime":"2020-07-07T20:00+08:00","speed":3.08,"direction":209.05},{"datetime":"2020-07-07T21:00+08:00","speed":2.97,"direction":208.2},{"datetime":"2020-07-07T22:00+08:00","speed":3.08,"direction":249.9},{"datetime":"2020-07-07T23:00+08:00","speed":3.8,"direction":277.76},{"datetime":"2020-07-08T00:00+08:00","speed":5.26,"direction":255.04},{"datetime":"2020-07-08T01:00+08:00","speed":5.88,"direction":235.49},{"datetime":"2020-07-08T02:00+08:00","speed":5.65,"direction":232.76},{"datetime":"2020-07-08T03:00+08:00","speed":4.6,"direction":219.17},{"datetime":"2020-07-08T04:00+08:00","speed":3.57,"direction":226.79},{"datetime":"2020-07-08T05:00+08:00","speed":3.93,"direction":247.22},{"datetime":"2020-07-08T06:00+08:00","speed":4.07,"direction":237.78},{"datetime":"2020-07-08T07:00+08:00","speed":3.45,"direction":241.24},{"datetime":"2020-07-08T08:00+08:00","speed":4.17,"direction":225.19}],"humidity":[{"datetime":"2020-07-06T09:00+08:00","value":0.78},{"datetime":"2020-07-06T10:00+08:00","value":0.67},{"datetime":"2020-07-06T11:00+08:00","value":0.65},{"datetime":"2020-07-06T12:00+08:00","value":0.64},{"datetime":"2020-07-06T13:00+08:00","value":0.65},{"datetime":"2020-07-06T14:00+08:00","value":0.66},{"datetime":"2020-07-06T15:00+08:00","value":0.67},{"datetime":"2020-07-06T16:00+08:00","value":0.69},{"datetime":"2020-07-06T17:00+08:00","value":0.72},{"datetime":"2020-07-06T18:00+08:00","value":0.75},{"datetime":"2020-07-06T19:00+08:00","value":0.78},{"datetime":"2020-07-06T20:00+08:00","value":0.78},{"datetime":"2020-07-06T21:00+08:00","value":0.78},{"datetime":"2020-07-06T22:00+08:00","value":0.8},{"datetime":"2020-07-06T23:00+08:00","value":0.81},{"datetime":"2020-07-07T00:00+08:00","value":0.81},{"datetime":"2020-07-07T01:00+08:00","value":0.8},{"datetime":"2020-07-07T02:00+08:00","value":0.8},{"datetime":"2020-07-07T03:00+08:00","value":0.81},{"datetime":"2020-07-07T04:00+08:00","value":0.81},{"datetime":"2020-07-07T05:00+08:00","value":0.79},{"datetime":"2020-07-07T06:00+08:00","value":0.81},{"datetime":"2020-07-07T07:00+08:00","value":0.77},{"datetime":"2020-07-07T08:00+08:00","value":0.73},{"datetime":"2020-07-07T09:00+08:00","value":0.7},{"datetime":"2020-07-07T10:00+08:00","value":0.66},{"datetime":"2020-07-07T11:00+08:00","value":0.64},{"datetime":"2020-07-07T12:00+08:00","value":0.65},{"datetime":"2020-07-07T13:00+08:00","value":0.67},{"datetime":"2020-07-07T14:00+08:00","value":0.69},{"datetime":"2020-07-07T15:00+08:00","value":0.68},{"datetime":"2020-07-07T16:00+08:00","value":0.7},{"datetime":"2020-07-07T17:00+08:00","value":0.73},{"datetime":"2020-07-07T18:00+08:00","value":0.75},{"datetime":"2020-07-07T19:00+08:00","value":0.78},{"datetime":"2020-07-07T20:00+08:00","value":0.79},{"datetime":"2020-07-07T21:00+08:00","value":0.8},{"datetime":"2020-07-07T22:00+08:00","value":0.79},{"datetime":"2020-07-07T23:00+08:00","value":0.79},{"datetime":"2020-07-08T00:00+08:00","value":0.8},{"datetime":"2020-07-08T01:00+08:00","value":0.8},{"datetime":"2020-07-08T02:00+08:00","value":0.8},{"datetime":"2020-07-08T03:00+08:00","value":0.8},{"datetime":"2020-07-08T04:00+08:00","value":0.8},{"datetime":"2020-07-08T05:00+08:00","value":0.81},{"datetime":"2020-07-08T06:00+08:00","value":0.8},{"datetime":"2020-07-08T07:00+08:00","value":0.78},{"datetime":"2020-07-08T08:00+08:00","value":0.74}],"cloudrate":[{"datetime":"2020-07-06T09:00+08:00","value":0.9},{"datetime":"2020-07-06T10:00+08:00","value":0.9},{"datetime":"2020-07-06T11:00+08:00","value":0.88},{"datetime":"2020-07-06T12:00+08:00","value":0.91},{"datetime":"2020-07-06T13:00+08:00","value":0.94},{"datetime":"2020-07-06T14:00+08:00","value":0.88},{"datetime":"2020-07-06T15:00+08:00","value":0.93},{"datetime":"2020-07-06T16:00+08:00","value":0.96},{"datetime":"2020-07-06T17:00+08:00","value":0.96},{"datetime":"2020-07-06T18:00+08:00","value":0.85},{"datetime":"2020-07-06T19:00+08:00","value":0.88},{"datetime":"2020-07-06T20:00+08:00","value":0.9},{"datetime":"2020-07-06T21:00+08:00","value":1},{"datetime":"2020-07-06T22:00+08:00","value":1},{"datetime":"2020-07-06T23:00+08:00","value":1},{"datetime":"2020-07-07T00:00+08:00","value":1},{"datetime":"2020-07-07T01:00+08:00","value":1},{"datetime":"2020-07-07T02:00+08:00","value":1},{"datetime":"2020-07-07T03:00+08:00","value":1},{"datetime":"2020-07-07T04:00+08:00","value":0.99},{"datetime":"2020-07-07T05:00+08:00","value":0.99},{"datetime":"2020-07-07T06:00+08:00","value":0.99},{"datetime":"2020-07-07T07:00+08:00","value":0.98},{"datetime":"2020-07-07T08:00+08:00","value":0.96},{"datetime":"2020-07-07T09:00+08:00","value":1},{"datetime":"2020-07-07T10:00+08:00","value":1},{"datetime":"2020-07-07T11:00+08:00","value":1},{"datetime":"2020-07-07T12:00+08:00","value":1},{"datetime":"2020-07-07T13:00+08:00","value":1},{"datetime":"2020-07-07T14:00+08:00","value":1},{"datetime":"2020-07-07T15:00+08:00","value":1},{"datetime":"2020-07-07T16:00+08:00","value":1},{"datetime":"2020-07-07T17:00+08:00","value":1},{"datetime":"2020-07-07T18:00+08:00","value":1},{"datetime":"2020-07-07T19:00+08:00","value":1},{"datetime":"2020-07-07T20:00+08:00","value":1},{"datetime":"2020-07-07T21:00+08:00","value":1},{"datetime":"2020-07-07T22:00+08:00","value":1},{"datetime":"2020-07-07T23:00+08:00","value":1},{"datetime":"2020-07-08T00:00+08:00","value":1},{"datetime":"2020-07-08T01:00+08:00","value":1},{"datetime":"2020-07-08T02:00+08:00","value":1},{"datetime":"2020-07-08T03:00+08:00","value":1},{"datetime":"2020-07-08T04:00+08:00","value":1},{"datetime":"2020-07-08T05:00+08:00","value":1},{"datetime":"2020-07-08T06:00+08:00","value":1},{"datetime":"2020-07-08T07:00+08:00","value":1},{"datetime":"2020-07-08T08:00+08:00","value":1}],"skycon":[{"datetime":"2020-07-06T09:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T10:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T11:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T12:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T13:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T14:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T15:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T16:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T17:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T18:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T19:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T20:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T21:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T22:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T23:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T00:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T01:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T02:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T03:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T04:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T05:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T06:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T07:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T08:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T09:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T10:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T11:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T12:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T13:00+08:00","value":"MODERATE_RAIN"},{"datetime":"2020-07-07T14:00+08:00","value":"LIGHT_RAIN"},{"datetime":"2020-07-07T15:00+08:00","value":"LIGHT_RAIN"},{"datetime":"2020-07-07T16:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T17:00+08:00","value":"HEAVY_RAIN"},{"datetime":"2020-07-07T18:00+08:00","value":"MODERATE_RAIN"},{"datetime":"2020-07-07T19:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T20:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T21:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T22:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T23:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T00:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T01:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T02:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T03:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T04:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T05:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T06:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T07:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T08:00+08:00","value":"CLOUDY"}],"pressure":[{"datetime":"2020-07-06T09:00+08:00","value":99066.5629696001},{"datetime":"2020-07-06T10:00+08:00","value":99066.5629696001},{"datetime":"2020-07-06T11:00+08:00","value":99054.9624832001},{"datetime":"2020-07-06T12:00+08:00","value":99054.9624832001},{"datetime":"2020-07-06T13:00+08:00","value":99005.5544832001},{"datetime":"2020-07-06T14:00+08:00","value":98993.9539968001},{"datetime":"2020-07-06T15:00+08:00","value":98925.5544832001},{"datetime":"2020-07-06T16:00+08:00","value":98913.9539968001},{"datetime":"2020-07-06T17:00+08:00","value":98913.9539968001},{"datetime":"2020-07-06T18:00+08:00","value":98993.9539968001},{"datetime":"2020-07-06T19:00+08:00","value":99085.5544832001},{"datetime":"2020-07-06T20:00+08:00","value":99165.5544832001},{"datetime":"2020-07-06T21:00+08:00","value":99165.5544832001},{"datetime":"2020-07-06T22:00+08:00","value":99184.2899968},{"datetime":"2020-07-06T23:00+08:00","value":99184.2899968001},{"datetime":"2020-07-07T00:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T01:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T02:00+08:00","value":99115.8904832001},{"datetime":"2020-07-07T03:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T04:00+08:00","value":99085.5544832},{"datetime":"2020-07-07T05:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T06:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T07:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T08:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T09:00+08:00","value":99306.5629696001},{"datetime":"2020-07-07T10:00+08:00","value":99294.9624832001},{"datetime":"2020-07-07T11:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T12:00+08:00","value":99233.9539968001},{"datetime":"2020-07-07T13:00+08:00","value":99214.9624832001},{"datetime":"2020-07-07T14:00+08:00","value":99153.9539968001},{"datetime":"2020-07-07T15:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T16:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T17:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T18:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T19:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T20:00+08:00","value":99226.5629696001},{"datetime":"2020-07-07T21:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T22:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T23:00+08:00","value":99245.5544832001},{"datetime":"2020-07-08T00:00+08:00","value":99165.5544832001},{"datetime":"2020-07-08T01:00+08:00","value":99085.5544832001},{"datetime":"2020-07-08T02:00+08:00","value":99035.8904832001},{"datetime":"2020-07-08T03:00+08:00","value":99005.5544832001},{"datetime":"2020-07-08T04:00+08:00","value":99005.5544832001},{"datetime":"2020-07-08T05:00+08:00","value":99035.8904832001},{"datetime":"2020-07-08T06:00+08:00","value":99085.5544832},{"datetime":"2020-07-08T07:00+08:00","value":99115.8904832001},{"datetime":"2020-07-08T08:00+08:00","value":99085.5544832001}],"visibility":[{"datetime":"2020-07-06T09:00+08:00","value":16},{"datetime":"2020-07-06T10:00+08:00","value":16},{"datetime":"2020-07-06T11:00+08:00","value":16},{"datetime":"2020-07-06T12:00+08:00","value":16},{"datetime":"2020-07-06T13:00+08:00","value":16},{"datetime":"2020-07-06T14:00+08:00","value":16},{"datetime":"2020-07-06T15:00+08:00","value":16},{"datetime":"2020-07-06T16:00+08:00","value":16},{"datetime":"2020-07-06T17:00+08:00","value":13.91},{"datetime":"2020-07-06T18:00+08:00","value":10.43},{"datetime":"2020-07-06T19:00+08:00","value":8.8},{"datetime":"2020-07-06T20:00+08:00","value":8.71},{"datetime":"2020-07-06T21:00+08:00","value":8.68},{"datetime":"2020-07-06T22:00+08:00","value":8.18},{"datetime":"2020-07-06T23:00+08:00","value":7.5},{"datetime":"2020-07-07T00:00+08:00","value":7.47},{"datetime":"2020-07-07T01:00+08:00","value":8.04},{"datetime":"2020-07-07T02:00+08:00","value":7.89},{"datetime":"2020-07-07T03:00+08:00","value":7.66},{"datetime":"2020-07-07T04:00+08:00","value":7.66},{"datetime":"2020-07-07T05:00+08:00","value":8.24},{"datetime":"2020-07-07T06:00+08:00","value":7.74},{"datetime":"2020-07-07T07:00+08:00","value":9.14},{"datetime":"2020-07-07T08:00+08:00","value":11.92},{"datetime":"2020-07-07T09:00+08:00","value":16},{"datetime":"2020-07-07T10:00+08:00","value":16},{"datetime":"2020-07-07T11:00+08:00","value":16},{"datetime":"2020-07-07T12:00+08:00","value":16},{"datetime":"2020-07-07T13:00+08:00","value":16},{"datetime":"2020-07-07T14:00+08:00","value":16},{"datetime":"2020-07-07T15:00+08:00","value":16},{"datetime":"2020-07-07T16:00+08:00","value":16},{"datetime":"2020-07-07T17:00+08:00","value":12.5},{"datetime":"2020-07-07T18:00+08:00","value":10.55},{"datetime":"2020-07-07T19:00+08:00","value":9.09},{"datetime":"2020-07-07T20:00+08:00","value":8.36},{"datetime":"2020-07-07T21:00+08:00","value":8.19},{"datetime":"2020-07-07T22:00+08:00","value":8.36},{"datetime":"2020-07-07T23:00+08:00","value":8.36},{"datetime":"2020-07-08T00:00+08:00","value":8.08},{"datetime":"2020-07-08T01:00+08:00","value":8.05},{"datetime":"2020-07-08T02:00+08:00","value":7.86},{"datetime":"2020-07-08T03:00+08:00","value":8.17},{"datetime":"2020-07-08T04:00+08:00","value":8.02},{"datetime":"2020-07-08T05:00+08:00","value":7.69},{"datetime":"2020-07-08T06:00+08:00","value":7.89},{"datetime":"2020-07-08T07:00+08:00","value":8.68},{"datetime":"2020-07-08T08:00+08:00","value":11.14}],"dswrf":[{"datetime":"2020-07-06T09:00+08:00","value":627.6260608},{"datetime":"2020-07-06T10:00+08:00","value":672.082304},{"datetime":"2020-07-06T11:00+08:00","value":721.56717824},{"datetime":"2020-07-06T12:00+08:00","value":769.26651136},{"datetime":"2020-07-06T13:00+08:00","value":782.08937216},{"datetime":"2020-07-06T14:00+08:00","value":808.38138368},{"datetime":"2020-07-06T15:00+08:00","value":732.9398784},{"datetime":"2020-07-06T16:00+08:00","value":643.8418176},{"datetime":"2020-07-06T17:00+08:00","value":547.6338176},{"datetime":"2020-07-06T18:00+08:00","value":455.2178176},{"datetime":"2020-07-06T19:00+08:00","value":370.4918784},{"datetime":"2020-07-06T20:00+08:00","value":306.71149056},{"datetime":"2020-07-06T21:00+08:00","value":0},{"datetime":"2020-07-06T22:00+08:00","value":0},{"datetime":"2020-07-06T23:00+08:00","value":0},{"datetime":"2020-07-07T00:00+08:00","value":0},{"datetime":"2020-07-07T01:00+08:00","value":0},{"datetime":"2020-07-07T02:00+08:00","value":0},{"datetime":"2020-07-07T03:00+08:00","value":0},{"datetime":"2020-07-07T04:00+08:00","value":0},{"datetime":"2020-07-07T05:00+08:00","value":0},{"datetime":"2020-07-07T06:00+08:00","value":10},{"datetime":"2020-07-07T07:00+08:00","value":40},{"datetime":"2020-07-07T08:00+08:00","value":98.2096},{"datetime":"2020-07-07T09:00+08:00","value":609.1821824},{"datetime":"2020-07-07T10:00+08:00","value":699.1181824},{"datetime":"2020-07-07T11:00+08:00","value":750.73400064},{"datetime":"2020-07-07T12:00+08:00","value":782.14021888},{"datetime":"2020-07-07T13:00+08:00","value":791.15077632},{"datetime":"2020-07-07T14:00+08:00","value":773.29339392},{"datetime":"2020-07-07T15:00+08:00","value":558.0382976},{"datetime":"2020-07-07T16:00+08:00","value":480.1105408},{"datetime":"2020-07-07T17:00+08:00","value":416.489088},{"datetime":"2020-07-07T18:00+08:00","value":343.1912704},{"datetime":"2020-07-07T19:00+08:00","value":282.267392},{"datetime":"2020-07-07T20:00+08:00","value":235.35393792},{"datetime":"2020-07-07T21:00+08:00","value":0},{"datetime":"2020-07-07T22:00+08:00","value":0},{"datetime":"2020-07-07T23:00+08:00","value":0},{"datetime":"2020-07-08T00:00+08:00","value":0},{"datetime":"2020-07-08T01:00+08:00","value":0},{"datetime":"2020-07-08T02:00+08:00","value":0},{"datetime":"2020-07-08T03:00+08:00","value":0},{"datetime":"2020-07-08T04:00+08:00","value":0},{"datetime":"2020-07-08T05:00+08:00","value":0},{"datetime":"2020-07-08T06:00+08:00","value":7.6260608},{"datetime":"2020-07-08T07:00+08:00","value":28.5499392},{"datetime":"2020-07-08T08:00+08:00","value":61.5773696}],"air_quality":{"aqi":[{"datetime":"2020-07-06T09:00+08:00","value":{"chn":13,"usa":13}},{"datetime":"2020-07-06T10:00+08:00","value":{"chn":11,"usa":11}},{"datetime":"2020-07-06T11:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2020-07-06T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T15:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T16:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T17:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T18:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T19:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T20:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T21:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T22:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T23:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T00:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T01:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T02:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T03:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T04:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T05:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T06:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T07:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T08:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T09:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T10:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T11:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T15:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T16:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T17:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T18:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T19:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T20:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T21:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T22:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T23:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T00:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T01:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T02:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T03:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T04:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T05:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T06:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T07:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T08:00+08:00","value":{"chn":7,"usa":7}}],"pm25":[{"datetime":"2020-07-06T09:00+08:00","value":6},{"datetime":"2020-07-06T10:00+08:00","value":5},{"datetime":"2020-07-06T11:00+08:00","value":4},{"datetime":"2020-07-06T12:00+08:00","value":4},{"datetime":"2020-07-06T13:00+08:00","value":3},{"datetime":"2020-07-06T14:00+08:00","value":3},{"datetime":"2020-07-06T15:00+08:00","value":4},{"datetime":"2020-07-06T16:00+08:00","value":4},{"datetime":"2020-07-06T17:00+08:00","value":4},{"datetime":"2020-07-06T18:00+08:00","value":3},{"datetime":"2020-07-06T19:00+08:00","value":3},{"datetime":"2020-07-06T20:00+08:00","value":3},{"datetime":"2020-07-06T21:00+08:00","value":4},{"datetime":"2020-07-06T22:00+08:00","value":4},{"datetime":"2020-07-06T23:00+08:00","value":4},{"datetime":"2020-07-07T00:00+08:00","value":4},{"datetime":"2020-07-07T01:00+08:00","value":3},{"datetime":"2020-07-07T02:00+08:00","value":3},{"datetime":"2020-07-07T03:00+08:00","value":4},{"datetime":"2020-07-07T04:00+08:00","value":3},{"datetime":"2020-07-07T05:00+08:00","value":3},{"datetime":"2020-07-07T06:00+08:00","value":4},{"datetime":"2020-07-07T07:00+08:00","value":4},{"datetime":"2020-07-07T08:00+08:00","value":4},{"datetime":"2020-07-07T09:00+08:00","value":3},{"datetime":"2020-07-07T10:00+08:00","value":3},{"datetime":"2020-07-07T11:00+08:00","value":3},{"datetime":"2020-07-07T12:00+08:00","value":3},{"datetime":"2020-07-07T13:00+08:00","value":4},{"datetime":"2020-07-07T14:00+08:00","value":4},{"datetime":"2020-07-07T15:00+08:00","value":4},{"datetime":"2020-07-07T16:00+08:00","value":3},{"datetime":"2020-07-07T17:00+08:00","value":3},{"datetime":"2020-07-07T18:00+08:00","value":4},{"datetime":"2020-07-07T19:00+08:00","value":4},{"datetime":"2020-07-07T20:00+08:00","value":4},{"datetime":"2020-07-07T21:00+08:00","value":4},{"datetime":"2020-07-07T22:00+08:00","value":5},{"datetime":"2020-07-07T23:00+08:00","value":5},{"datetime":"2020-07-08T00:00+08:00","value":4},{"datetime":"2020-07-08T01:00+08:00","value":4},{"datetime":"2020-07-08T02:00+08:00","value":4},{"datetime":"2020-07-08T03:00+08:00","value":5},{"datetime":"2020-07-08T04:00+08:00","value":4},{"datetime":"2020-07-08T05:00+08:00","value":4},{"datetime":"2020-07-08T06:00+08:00","value":5},{"datetime":"2020-07-08T07:00+08:00","value":5},{"datetime":"2020-07-08T08:00+08:00","value":5}]}},"primary":0,"forecast_keypoint":"未来24小时阴"}
     */

    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private int tzshift;
    private String timezone;
    private int server_time;
    private ResultBean result;
    private List<Double> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * hourly : {"status":"ok","description":"未来24小时阴","precipitation":[{"datetime":"2020-07-06T09:00+08:00","value":0},{"datetime":"2020-07-06T10:00+08:00","value":0},{"datetime":"2020-07-06T11:00+08:00","value":0},{"datetime":"2020-07-06T12:00+08:00","value":0},{"datetime":"2020-07-06T13:00+08:00","value":0},{"datetime":"2020-07-06T14:00+08:00","value":0},{"datetime":"2020-07-06T15:00+08:00","value":0},{"datetime":"2020-07-06T16:00+08:00","value":0},{"datetime":"2020-07-06T17:00+08:00","value":0},{"datetime":"2020-07-06T18:00+08:00","value":0},{"datetime":"2020-07-06T19:00+08:00","value":0},{"datetime":"2020-07-06T20:00+08:00","value":0},{"datetime":"2020-07-06T21:00+08:00","value":0},{"datetime":"2020-07-06T22:00+08:00","value":0},{"datetime":"2020-07-06T23:00+08:00","value":0},{"datetime":"2020-07-07T00:00+08:00","value":0},{"datetime":"2020-07-07T01:00+08:00","value":0},{"datetime":"2020-07-07T02:00+08:00","value":0},{"datetime":"2020-07-07T03:00+08:00","value":0},{"datetime":"2020-07-07T04:00+08:00","value":0},{"datetime":"2020-07-07T05:00+08:00","value":0},{"datetime":"2020-07-07T06:00+08:00","value":0},{"datetime":"2020-07-07T07:00+08:00","value":0},{"datetime":"2020-07-07T08:00+08:00","value":0},{"datetime":"2020-07-07T09:00+08:00","value":0},{"datetime":"2020-07-07T10:00+08:00","value":0},{"datetime":"2020-07-07T11:00+08:00","value":0},{"datetime":"2020-07-07T12:00+08:00","value":0},{"datetime":"2020-07-07T13:00+08:00","value":1.1582},{"datetime":"2020-07-07T14:00+08:00","value":0.1393},{"datetime":"2020-07-07T15:00+08:00","value":0.2389},{"datetime":"2020-07-07T16:00+08:00","value":0},{"datetime":"2020-07-07T17:00+08:00","value":5.2516},{"datetime":"2020-07-07T18:00+08:00","value":0.9416},{"datetime":"2020-07-07T19:00+08:00","value":0},{"datetime":"2020-07-07T20:00+08:00","value":0},{"datetime":"2020-07-07T21:00+08:00","value":0},{"datetime":"2020-07-07T22:00+08:00","value":0},{"datetime":"2020-07-07T23:00+08:00","value":0},{"datetime":"2020-07-08T00:00+08:00","value":0},{"datetime":"2020-07-08T01:00+08:00","value":0},{"datetime":"2020-07-08T02:00+08:00","value":0},{"datetime":"2020-07-08T03:00+08:00","value":0},{"datetime":"2020-07-08T04:00+08:00","value":0},{"datetime":"2020-07-08T05:00+08:00","value":0},{"datetime":"2020-07-08T06:00+08:00","value":0},{"datetime":"2020-07-08T07:00+08:00","value":0},{"datetime":"2020-07-08T08:00+08:00","value":0}],"temperature":[{"datetime":"2020-07-06T09:00+08:00","value":30.16},{"datetime":"2020-07-06T10:00+08:00","value":30.97},{"datetime":"2020-07-06T11:00+08:00","value":30.77},{"datetime":"2020-07-06T12:00+08:00","value":30.58},{"datetime":"2020-07-06T13:00+08:00","value":31},{"datetime":"2020-07-06T14:00+08:00","value":31},{"datetime":"2020-07-06T15:00+08:00","value":30},{"datetime":"2020-07-06T16:00+08:00","value":30},{"datetime":"2020-07-06T17:00+08:00","value":29},{"datetime":"2020-07-06T18:00+08:00","value":28.7},{"datetime":"2020-07-06T19:00+08:00","value":27.6},{"datetime":"2020-07-06T20:00+08:00","value":27.4},{"datetime":"2020-07-06T21:00+08:00","value":26.6},{"datetime":"2020-07-06T22:00+08:00","value":26.5},{"datetime":"2020-07-06T23:00+08:00","value":26.4},{"datetime":"2020-07-07T00:00+08:00","value":26.3},{"datetime":"2020-07-07T01:00+08:00","value":26.2},{"datetime":"2020-07-07T02:00+08:00","value":26.5},{"datetime":"2020-07-07T03:00+08:00","value":26},{"datetime":"2020-07-07T04:00+08:00","value":27.5},{"datetime":"2020-07-07T05:00+08:00","value":28},{"datetime":"2020-07-07T06:00+08:00","value":28.3},{"datetime":"2020-07-07T07:00+08:00","value":28.6},{"datetime":"2020-07-07T08:00+08:00","value":29.1},{"datetime":"2020-07-07T09:00+08:00","value":29.12},{"datetime":"2020-07-07T10:00+08:00","value":29.44},{"datetime":"2020-07-07T11:00+08:00","value":31},{"datetime":"2020-07-07T12:00+08:00","value":30.5},{"datetime":"2020-07-07T13:00+08:00","value":31},{"datetime":"2020-07-07T14:00+08:00","value":31},{"datetime":"2020-07-07T15:00+08:00","value":30.92},{"datetime":"2020-07-07T16:00+08:00","value":30.74},{"datetime":"2020-07-07T17:00+08:00","value":30.47},{"datetime":"2020-07-07T18:00+08:00","value":30.02},{"datetime":"2020-07-07T19:00+08:00","value":29.31},{"datetime":"2020-07-07T20:00+08:00","value":28.64},{"datetime":"2020-07-07T21:00+08:00","value":28.04},{"datetime":"2020-07-07T22:00+08:00","value":27.69},{"datetime":"2020-07-07T23:00+08:00","value":27.26},{"datetime":"2020-07-08T00:00+08:00","value":27.03},{"datetime":"2020-07-08T01:00+08:00","value":26.78},{"datetime":"2020-07-08T02:00+08:00","value":26.55},{"datetime":"2020-07-08T03:00+08:00","value":26.68},{"datetime":"2020-07-08T04:00+08:00","value":26.83},{"datetime":"2020-07-08T05:00+08:00","value":26},{"datetime":"2020-07-08T06:00+08:00","value":27.45},{"datetime":"2020-07-08T07:00+08:00","value":27.8},{"datetime":"2020-07-08T08:00+08:00","value":28.12}],"wind":[{"datetime":"2020-07-06T09:00+08:00","speed":27.72,"direction":220},{"datetime":"2020-07-06T10:00+08:00","speed":2.88,"direction":273.62},{"datetime":"2020-07-06T11:00+08:00","speed":2.42,"direction":224.64},{"datetime":"2020-07-06T12:00+08:00","speed":1.11,"direction":236.15},{"datetime":"2020-07-06T13:00+08:00","speed":2.04,"direction":159},{"datetime":"2020-07-06T14:00+08:00","speed":4.32,"direction":110.5},{"datetime":"2020-07-06T15:00+08:00","speed":5.68,"direction":139.36},{"datetime":"2020-07-06T16:00+08:00","speed":1.94,"direction":178.26},{"datetime":"2020-07-06T17:00+08:00","speed":0.49,"direction":160.55},{"datetime":"2020-07-06T18:00+08:00","speed":1.01,"direction":20.17},{"datetime":"2020-07-06T19:00+08:00","speed":0.33,"direction":47.68},{"datetime":"2020-07-06T20:00+08:00","speed":1,"direction":235.32},{"datetime":"2020-07-06T21:00+08:00","speed":1.23,"direction":205.24},{"datetime":"2020-07-06T22:00+08:00","speed":2.75,"direction":160.72},{"datetime":"2020-07-06T23:00+08:00","speed":3.32,"direction":161.07},{"datetime":"2020-07-07T00:00+08:00","speed":3.19,"direction":241.98},{"datetime":"2020-07-07T01:00+08:00","speed":6.57,"direction":284.5},{"datetime":"2020-07-07T02:00+08:00","speed":6.14,"direction":271.19},{"datetime":"2020-07-07T03:00+08:00","speed":6.52,"direction":248.05},{"datetime":"2020-07-07T04:00+08:00","speed":7.26,"direction":226.23},{"datetime":"2020-07-07T05:00+08:00","speed":5.41,"direction":206.36},{"datetime":"2020-07-07T06:00+08:00","speed":3.12,"direction":210.7},{"datetime":"2020-07-07T07:00+08:00","speed":3.24,"direction":206.76},{"datetime":"2020-07-07T08:00+08:00","speed":3.41,"direction":202.98},{"datetime":"2020-07-07T09:00+08:00","speed":2.4,"direction":223.65},{"datetime":"2020-07-07T10:00+08:00","speed":2.77,"direction":297.79},{"datetime":"2020-07-07T11:00+08:00","speed":2.42,"direction":279.24},{"datetime":"2020-07-07T12:00+08:00","speed":4.27,"direction":307.68},{"datetime":"2020-07-07T13:00+08:00","speed":5.87,"direction":281.4},{"datetime":"2020-07-07T14:00+08:00","speed":7.14,"direction":254.24},{"datetime":"2020-07-07T15:00+08:00","speed":6.29,"direction":247.52},{"datetime":"2020-07-07T16:00+08:00","speed":4.51,"direction":231.76},{"datetime":"2020-07-07T17:00+08:00","speed":2.72,"direction":196.75},{"datetime":"2020-07-07T18:00+08:00","speed":4.72,"direction":177.88},{"datetime":"2020-07-07T19:00+08:00","speed":3.38,"direction":200.46},{"datetime":"2020-07-07T20:00+08:00","speed":3.08,"direction":209.05},{"datetime":"2020-07-07T21:00+08:00","speed":2.97,"direction":208.2},{"datetime":"2020-07-07T22:00+08:00","speed":3.08,"direction":249.9},{"datetime":"2020-07-07T23:00+08:00","speed":3.8,"direction":277.76},{"datetime":"2020-07-08T00:00+08:00","speed":5.26,"direction":255.04},{"datetime":"2020-07-08T01:00+08:00","speed":5.88,"direction":235.49},{"datetime":"2020-07-08T02:00+08:00","speed":5.65,"direction":232.76},{"datetime":"2020-07-08T03:00+08:00","speed":4.6,"direction":219.17},{"datetime":"2020-07-08T04:00+08:00","speed":3.57,"direction":226.79},{"datetime":"2020-07-08T05:00+08:00","speed":3.93,"direction":247.22},{"datetime":"2020-07-08T06:00+08:00","speed":4.07,"direction":237.78},{"datetime":"2020-07-08T07:00+08:00","speed":3.45,"direction":241.24},{"datetime":"2020-07-08T08:00+08:00","speed":4.17,"direction":225.19}],"humidity":[{"datetime":"2020-07-06T09:00+08:00","value":0.78},{"datetime":"2020-07-06T10:00+08:00","value":0.67},{"datetime":"2020-07-06T11:00+08:00","value":0.65},{"datetime":"2020-07-06T12:00+08:00","value":0.64},{"datetime":"2020-07-06T13:00+08:00","value":0.65},{"datetime":"2020-07-06T14:00+08:00","value":0.66},{"datetime":"2020-07-06T15:00+08:00","value":0.67},{"datetime":"2020-07-06T16:00+08:00","value":0.69},{"datetime":"2020-07-06T17:00+08:00","value":0.72},{"datetime":"2020-07-06T18:00+08:00","value":0.75},{"datetime":"2020-07-06T19:00+08:00","value":0.78},{"datetime":"2020-07-06T20:00+08:00","value":0.78},{"datetime":"2020-07-06T21:00+08:00","value":0.78},{"datetime":"2020-07-06T22:00+08:00","value":0.8},{"datetime":"2020-07-06T23:00+08:00","value":0.81},{"datetime":"2020-07-07T00:00+08:00","value":0.81},{"datetime":"2020-07-07T01:00+08:00","value":0.8},{"datetime":"2020-07-07T02:00+08:00","value":0.8},{"datetime":"2020-07-07T03:00+08:00","value":0.81},{"datetime":"2020-07-07T04:00+08:00","value":0.81},{"datetime":"2020-07-07T05:00+08:00","value":0.79},{"datetime":"2020-07-07T06:00+08:00","value":0.81},{"datetime":"2020-07-07T07:00+08:00","value":0.77},{"datetime":"2020-07-07T08:00+08:00","value":0.73},{"datetime":"2020-07-07T09:00+08:00","value":0.7},{"datetime":"2020-07-07T10:00+08:00","value":0.66},{"datetime":"2020-07-07T11:00+08:00","value":0.64},{"datetime":"2020-07-07T12:00+08:00","value":0.65},{"datetime":"2020-07-07T13:00+08:00","value":0.67},{"datetime":"2020-07-07T14:00+08:00","value":0.69},{"datetime":"2020-07-07T15:00+08:00","value":0.68},{"datetime":"2020-07-07T16:00+08:00","value":0.7},{"datetime":"2020-07-07T17:00+08:00","value":0.73},{"datetime":"2020-07-07T18:00+08:00","value":0.75},{"datetime":"2020-07-07T19:00+08:00","value":0.78},{"datetime":"2020-07-07T20:00+08:00","value":0.79},{"datetime":"2020-07-07T21:00+08:00","value":0.8},{"datetime":"2020-07-07T22:00+08:00","value":0.79},{"datetime":"2020-07-07T23:00+08:00","value":0.79},{"datetime":"2020-07-08T00:00+08:00","value":0.8},{"datetime":"2020-07-08T01:00+08:00","value":0.8},{"datetime":"2020-07-08T02:00+08:00","value":0.8},{"datetime":"2020-07-08T03:00+08:00","value":0.8},{"datetime":"2020-07-08T04:00+08:00","value":0.8},{"datetime":"2020-07-08T05:00+08:00","value":0.81},{"datetime":"2020-07-08T06:00+08:00","value":0.8},{"datetime":"2020-07-08T07:00+08:00","value":0.78},{"datetime":"2020-07-08T08:00+08:00","value":0.74}],"cloudrate":[{"datetime":"2020-07-06T09:00+08:00","value":0.9},{"datetime":"2020-07-06T10:00+08:00","value":0.9},{"datetime":"2020-07-06T11:00+08:00","value":0.88},{"datetime":"2020-07-06T12:00+08:00","value":0.91},{"datetime":"2020-07-06T13:00+08:00","value":0.94},{"datetime":"2020-07-06T14:00+08:00","value":0.88},{"datetime":"2020-07-06T15:00+08:00","value":0.93},{"datetime":"2020-07-06T16:00+08:00","value":0.96},{"datetime":"2020-07-06T17:00+08:00","value":0.96},{"datetime":"2020-07-06T18:00+08:00","value":0.85},{"datetime":"2020-07-06T19:00+08:00","value":0.88},{"datetime":"2020-07-06T20:00+08:00","value":0.9},{"datetime":"2020-07-06T21:00+08:00","value":1},{"datetime":"2020-07-06T22:00+08:00","value":1},{"datetime":"2020-07-06T23:00+08:00","value":1},{"datetime":"2020-07-07T00:00+08:00","value":1},{"datetime":"2020-07-07T01:00+08:00","value":1},{"datetime":"2020-07-07T02:00+08:00","value":1},{"datetime":"2020-07-07T03:00+08:00","value":1},{"datetime":"2020-07-07T04:00+08:00","value":0.99},{"datetime":"2020-07-07T05:00+08:00","value":0.99},{"datetime":"2020-07-07T06:00+08:00","value":0.99},{"datetime":"2020-07-07T07:00+08:00","value":0.98},{"datetime":"2020-07-07T08:00+08:00","value":0.96},{"datetime":"2020-07-07T09:00+08:00","value":1},{"datetime":"2020-07-07T10:00+08:00","value":1},{"datetime":"2020-07-07T11:00+08:00","value":1},{"datetime":"2020-07-07T12:00+08:00","value":1},{"datetime":"2020-07-07T13:00+08:00","value":1},{"datetime":"2020-07-07T14:00+08:00","value":1},{"datetime":"2020-07-07T15:00+08:00","value":1},{"datetime":"2020-07-07T16:00+08:00","value":1},{"datetime":"2020-07-07T17:00+08:00","value":1},{"datetime":"2020-07-07T18:00+08:00","value":1},{"datetime":"2020-07-07T19:00+08:00","value":1},{"datetime":"2020-07-07T20:00+08:00","value":1},{"datetime":"2020-07-07T21:00+08:00","value":1},{"datetime":"2020-07-07T22:00+08:00","value":1},{"datetime":"2020-07-07T23:00+08:00","value":1},{"datetime":"2020-07-08T00:00+08:00","value":1},{"datetime":"2020-07-08T01:00+08:00","value":1},{"datetime":"2020-07-08T02:00+08:00","value":1},{"datetime":"2020-07-08T03:00+08:00","value":1},{"datetime":"2020-07-08T04:00+08:00","value":1},{"datetime":"2020-07-08T05:00+08:00","value":1},{"datetime":"2020-07-08T06:00+08:00","value":1},{"datetime":"2020-07-08T07:00+08:00","value":1},{"datetime":"2020-07-08T08:00+08:00","value":1}],"skycon":[{"datetime":"2020-07-06T09:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T10:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T11:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T12:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T13:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T14:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T15:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T16:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T17:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T18:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T19:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T20:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T21:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T22:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T23:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T00:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T01:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T02:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T03:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T04:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T05:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T06:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T07:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T08:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T09:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T10:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T11:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T12:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T13:00+08:00","value":"MODERATE_RAIN"},{"datetime":"2020-07-07T14:00+08:00","value":"LIGHT_RAIN"},{"datetime":"2020-07-07T15:00+08:00","value":"LIGHT_RAIN"},{"datetime":"2020-07-07T16:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T17:00+08:00","value":"HEAVY_RAIN"},{"datetime":"2020-07-07T18:00+08:00","value":"MODERATE_RAIN"},{"datetime":"2020-07-07T19:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T20:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T21:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T22:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T23:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T00:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T01:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T02:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T03:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T04:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T05:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T06:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T07:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T08:00+08:00","value":"CLOUDY"}],"pressure":[{"datetime":"2020-07-06T09:00+08:00","value":99066.5629696001},{"datetime":"2020-07-06T10:00+08:00","value":99066.5629696001},{"datetime":"2020-07-06T11:00+08:00","value":99054.9624832001},{"datetime":"2020-07-06T12:00+08:00","value":99054.9624832001},{"datetime":"2020-07-06T13:00+08:00","value":99005.5544832001},{"datetime":"2020-07-06T14:00+08:00","value":98993.9539968001},{"datetime":"2020-07-06T15:00+08:00","value":98925.5544832001},{"datetime":"2020-07-06T16:00+08:00","value":98913.9539968001},{"datetime":"2020-07-06T17:00+08:00","value":98913.9539968001},{"datetime":"2020-07-06T18:00+08:00","value":98993.9539968001},{"datetime":"2020-07-06T19:00+08:00","value":99085.5544832001},{"datetime":"2020-07-06T20:00+08:00","value":99165.5544832001},{"datetime":"2020-07-06T21:00+08:00","value":99165.5544832001},{"datetime":"2020-07-06T22:00+08:00","value":99184.2899968},{"datetime":"2020-07-06T23:00+08:00","value":99184.2899968001},{"datetime":"2020-07-07T00:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T01:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T02:00+08:00","value":99115.8904832001},{"datetime":"2020-07-07T03:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T04:00+08:00","value":99085.5544832},{"datetime":"2020-07-07T05:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T06:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T07:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T08:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T09:00+08:00","value":99306.5629696001},{"datetime":"2020-07-07T10:00+08:00","value":99294.9624832001},{"datetime":"2020-07-07T11:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T12:00+08:00","value":99233.9539968001},{"datetime":"2020-07-07T13:00+08:00","value":99214.9624832001},{"datetime":"2020-07-07T14:00+08:00","value":99153.9539968001},{"datetime":"2020-07-07T15:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T16:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T17:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T18:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T19:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T20:00+08:00","value":99226.5629696001},{"datetime":"2020-07-07T21:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T22:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T23:00+08:00","value":99245.5544832001},{"datetime":"2020-07-08T00:00+08:00","value":99165.5544832001},{"datetime":"2020-07-08T01:00+08:00","value":99085.5544832001},{"datetime":"2020-07-08T02:00+08:00","value":99035.8904832001},{"datetime":"2020-07-08T03:00+08:00","value":99005.5544832001},{"datetime":"2020-07-08T04:00+08:00","value":99005.5544832001},{"datetime":"2020-07-08T05:00+08:00","value":99035.8904832001},{"datetime":"2020-07-08T06:00+08:00","value":99085.5544832},{"datetime":"2020-07-08T07:00+08:00","value":99115.8904832001},{"datetime":"2020-07-08T08:00+08:00","value":99085.5544832001}],"visibility":[{"datetime":"2020-07-06T09:00+08:00","value":16},{"datetime":"2020-07-06T10:00+08:00","value":16},{"datetime":"2020-07-06T11:00+08:00","value":16},{"datetime":"2020-07-06T12:00+08:00","value":16},{"datetime":"2020-07-06T13:00+08:00","value":16},{"datetime":"2020-07-06T14:00+08:00","value":16},{"datetime":"2020-07-06T15:00+08:00","value":16},{"datetime":"2020-07-06T16:00+08:00","value":16},{"datetime":"2020-07-06T17:00+08:00","value":13.91},{"datetime":"2020-07-06T18:00+08:00","value":10.43},{"datetime":"2020-07-06T19:00+08:00","value":8.8},{"datetime":"2020-07-06T20:00+08:00","value":8.71},{"datetime":"2020-07-06T21:00+08:00","value":8.68},{"datetime":"2020-07-06T22:00+08:00","value":8.18},{"datetime":"2020-07-06T23:00+08:00","value":7.5},{"datetime":"2020-07-07T00:00+08:00","value":7.47},{"datetime":"2020-07-07T01:00+08:00","value":8.04},{"datetime":"2020-07-07T02:00+08:00","value":7.89},{"datetime":"2020-07-07T03:00+08:00","value":7.66},{"datetime":"2020-07-07T04:00+08:00","value":7.66},{"datetime":"2020-07-07T05:00+08:00","value":8.24},{"datetime":"2020-07-07T06:00+08:00","value":7.74},{"datetime":"2020-07-07T07:00+08:00","value":9.14},{"datetime":"2020-07-07T08:00+08:00","value":11.92},{"datetime":"2020-07-07T09:00+08:00","value":16},{"datetime":"2020-07-07T10:00+08:00","value":16},{"datetime":"2020-07-07T11:00+08:00","value":16},{"datetime":"2020-07-07T12:00+08:00","value":16},{"datetime":"2020-07-07T13:00+08:00","value":16},{"datetime":"2020-07-07T14:00+08:00","value":16},{"datetime":"2020-07-07T15:00+08:00","value":16},{"datetime":"2020-07-07T16:00+08:00","value":16},{"datetime":"2020-07-07T17:00+08:00","value":12.5},{"datetime":"2020-07-07T18:00+08:00","value":10.55},{"datetime":"2020-07-07T19:00+08:00","value":9.09},{"datetime":"2020-07-07T20:00+08:00","value":8.36},{"datetime":"2020-07-07T21:00+08:00","value":8.19},{"datetime":"2020-07-07T22:00+08:00","value":8.36},{"datetime":"2020-07-07T23:00+08:00","value":8.36},{"datetime":"2020-07-08T00:00+08:00","value":8.08},{"datetime":"2020-07-08T01:00+08:00","value":8.05},{"datetime":"2020-07-08T02:00+08:00","value":7.86},{"datetime":"2020-07-08T03:00+08:00","value":8.17},{"datetime":"2020-07-08T04:00+08:00","value":8.02},{"datetime":"2020-07-08T05:00+08:00","value":7.69},{"datetime":"2020-07-08T06:00+08:00","value":7.89},{"datetime":"2020-07-08T07:00+08:00","value":8.68},{"datetime":"2020-07-08T08:00+08:00","value":11.14}],"dswrf":[{"datetime":"2020-07-06T09:00+08:00","value":627.6260608},{"datetime":"2020-07-06T10:00+08:00","value":672.082304},{"datetime":"2020-07-06T11:00+08:00","value":721.56717824},{"datetime":"2020-07-06T12:00+08:00","value":769.26651136},{"datetime":"2020-07-06T13:00+08:00","value":782.08937216},{"datetime":"2020-07-06T14:00+08:00","value":808.38138368},{"datetime":"2020-07-06T15:00+08:00","value":732.9398784},{"datetime":"2020-07-06T16:00+08:00","value":643.8418176},{"datetime":"2020-07-06T17:00+08:00","value":547.6338176},{"datetime":"2020-07-06T18:00+08:00","value":455.2178176},{"datetime":"2020-07-06T19:00+08:00","value":370.4918784},{"datetime":"2020-07-06T20:00+08:00","value":306.71149056},{"datetime":"2020-07-06T21:00+08:00","value":0},{"datetime":"2020-07-06T22:00+08:00","value":0},{"datetime":"2020-07-06T23:00+08:00","value":0},{"datetime":"2020-07-07T00:00+08:00","value":0},{"datetime":"2020-07-07T01:00+08:00","value":0},{"datetime":"2020-07-07T02:00+08:00","value":0},{"datetime":"2020-07-07T03:00+08:00","value":0},{"datetime":"2020-07-07T04:00+08:00","value":0},{"datetime":"2020-07-07T05:00+08:00","value":0},{"datetime":"2020-07-07T06:00+08:00","value":10},{"datetime":"2020-07-07T07:00+08:00","value":40},{"datetime":"2020-07-07T08:00+08:00","value":98.2096},{"datetime":"2020-07-07T09:00+08:00","value":609.1821824},{"datetime":"2020-07-07T10:00+08:00","value":699.1181824},{"datetime":"2020-07-07T11:00+08:00","value":750.73400064},{"datetime":"2020-07-07T12:00+08:00","value":782.14021888},{"datetime":"2020-07-07T13:00+08:00","value":791.15077632},{"datetime":"2020-07-07T14:00+08:00","value":773.29339392},{"datetime":"2020-07-07T15:00+08:00","value":558.0382976},{"datetime":"2020-07-07T16:00+08:00","value":480.1105408},{"datetime":"2020-07-07T17:00+08:00","value":416.489088},{"datetime":"2020-07-07T18:00+08:00","value":343.1912704},{"datetime":"2020-07-07T19:00+08:00","value":282.267392},{"datetime":"2020-07-07T20:00+08:00","value":235.35393792},{"datetime":"2020-07-07T21:00+08:00","value":0},{"datetime":"2020-07-07T22:00+08:00","value":0},{"datetime":"2020-07-07T23:00+08:00","value":0},{"datetime":"2020-07-08T00:00+08:00","value":0},{"datetime":"2020-07-08T01:00+08:00","value":0},{"datetime":"2020-07-08T02:00+08:00","value":0},{"datetime":"2020-07-08T03:00+08:00","value":0},{"datetime":"2020-07-08T04:00+08:00","value":0},{"datetime":"2020-07-08T05:00+08:00","value":0},{"datetime":"2020-07-08T06:00+08:00","value":7.6260608},{"datetime":"2020-07-08T07:00+08:00","value":28.5499392},{"datetime":"2020-07-08T08:00+08:00","value":61.5773696}],"air_quality":{"aqi":[{"datetime":"2020-07-06T09:00+08:00","value":{"chn":13,"usa":13}},{"datetime":"2020-07-06T10:00+08:00","value":{"chn":11,"usa":11}},{"datetime":"2020-07-06T11:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2020-07-06T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T15:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T16:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T17:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T18:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T19:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T20:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T21:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T22:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T23:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T00:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T01:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T02:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T03:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T04:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T05:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T06:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T07:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T08:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T09:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T10:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T11:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T15:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T16:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T17:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T18:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T19:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T20:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T21:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T22:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T23:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T00:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T01:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T02:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T03:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T04:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T05:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T06:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T07:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T08:00+08:00","value":{"chn":7,"usa":7}}],"pm25":[{"datetime":"2020-07-06T09:00+08:00","value":6},{"datetime":"2020-07-06T10:00+08:00","value":5},{"datetime":"2020-07-06T11:00+08:00","value":4},{"datetime":"2020-07-06T12:00+08:00","value":4},{"datetime":"2020-07-06T13:00+08:00","value":3},{"datetime":"2020-07-06T14:00+08:00","value":3},{"datetime":"2020-07-06T15:00+08:00","value":4},{"datetime":"2020-07-06T16:00+08:00","value":4},{"datetime":"2020-07-06T17:00+08:00","value":4},{"datetime":"2020-07-06T18:00+08:00","value":3},{"datetime":"2020-07-06T19:00+08:00","value":3},{"datetime":"2020-07-06T20:00+08:00","value":3},{"datetime":"2020-07-06T21:00+08:00","value":4},{"datetime":"2020-07-06T22:00+08:00","value":4},{"datetime":"2020-07-06T23:00+08:00","value":4},{"datetime":"2020-07-07T00:00+08:00","value":4},{"datetime":"2020-07-07T01:00+08:00","value":3},{"datetime":"2020-07-07T02:00+08:00","value":3},{"datetime":"2020-07-07T03:00+08:00","value":4},{"datetime":"2020-07-07T04:00+08:00","value":3},{"datetime":"2020-07-07T05:00+08:00","value":3},{"datetime":"2020-07-07T06:00+08:00","value":4},{"datetime":"2020-07-07T07:00+08:00","value":4},{"datetime":"2020-07-07T08:00+08:00","value":4},{"datetime":"2020-07-07T09:00+08:00","value":3},{"datetime":"2020-07-07T10:00+08:00","value":3},{"datetime":"2020-07-07T11:00+08:00","value":3},{"datetime":"2020-07-07T12:00+08:00","value":3},{"datetime":"2020-07-07T13:00+08:00","value":4},{"datetime":"2020-07-07T14:00+08:00","value":4},{"datetime":"2020-07-07T15:00+08:00","value":4},{"datetime":"2020-07-07T16:00+08:00","value":3},{"datetime":"2020-07-07T17:00+08:00","value":3},{"datetime":"2020-07-07T18:00+08:00","value":4},{"datetime":"2020-07-07T19:00+08:00","value":4},{"datetime":"2020-07-07T20:00+08:00","value":4},{"datetime":"2020-07-07T21:00+08:00","value":4},{"datetime":"2020-07-07T22:00+08:00","value":5},{"datetime":"2020-07-07T23:00+08:00","value":5},{"datetime":"2020-07-08T00:00+08:00","value":4},{"datetime":"2020-07-08T01:00+08:00","value":4},{"datetime":"2020-07-08T02:00+08:00","value":4},{"datetime":"2020-07-08T03:00+08:00","value":5},{"datetime":"2020-07-08T04:00+08:00","value":4},{"datetime":"2020-07-08T05:00+08:00","value":4},{"datetime":"2020-07-08T06:00+08:00","value":5},{"datetime":"2020-07-08T07:00+08:00","value":5},{"datetime":"2020-07-08T08:00+08:00","value":5}]}}
         * primary : 0
         * forecast_keypoint : 未来24小时阴
         */

        private HourlyBean hourly;
        private int primary;
        private String forecast_keypoint;

        public HourlyBean getHourly() {
            return hourly;
        }

        public void setHourly(HourlyBean hourly) {
            this.hourly = hourly;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public String getForecast_keypoint() {
            return forecast_keypoint;
        }

        public void setForecast_keypoint(String forecast_keypoint) {
            this.forecast_keypoint = forecast_keypoint;
        }

        public static class HourlyBean {
            /**
             * status : ok
             * description : 未来24小时阴
             * precipitation : [{"datetime":"2020-07-06T09:00+08:00","value":0},{"datetime":"2020-07-06T10:00+08:00","value":0},{"datetime":"2020-07-06T11:00+08:00","value":0},{"datetime":"2020-07-06T12:00+08:00","value":0},{"datetime":"2020-07-06T13:00+08:00","value":0},{"datetime":"2020-07-06T14:00+08:00","value":0},{"datetime":"2020-07-06T15:00+08:00","value":0},{"datetime":"2020-07-06T16:00+08:00","value":0},{"datetime":"2020-07-06T17:00+08:00","value":0},{"datetime":"2020-07-06T18:00+08:00","value":0},{"datetime":"2020-07-06T19:00+08:00","value":0},{"datetime":"2020-07-06T20:00+08:00","value":0},{"datetime":"2020-07-06T21:00+08:00","value":0},{"datetime":"2020-07-06T22:00+08:00","value":0},{"datetime":"2020-07-06T23:00+08:00","value":0},{"datetime":"2020-07-07T00:00+08:00","value":0},{"datetime":"2020-07-07T01:00+08:00","value":0},{"datetime":"2020-07-07T02:00+08:00","value":0},{"datetime":"2020-07-07T03:00+08:00","value":0},{"datetime":"2020-07-07T04:00+08:00","value":0},{"datetime":"2020-07-07T05:00+08:00","value":0},{"datetime":"2020-07-07T06:00+08:00","value":0},{"datetime":"2020-07-07T07:00+08:00","value":0},{"datetime":"2020-07-07T08:00+08:00","value":0},{"datetime":"2020-07-07T09:00+08:00","value":0},{"datetime":"2020-07-07T10:00+08:00","value":0},{"datetime":"2020-07-07T11:00+08:00","value":0},{"datetime":"2020-07-07T12:00+08:00","value":0},{"datetime":"2020-07-07T13:00+08:00","value":1.1582},{"datetime":"2020-07-07T14:00+08:00","value":0.1393},{"datetime":"2020-07-07T15:00+08:00","value":0.2389},{"datetime":"2020-07-07T16:00+08:00","value":0},{"datetime":"2020-07-07T17:00+08:00","value":5.2516},{"datetime":"2020-07-07T18:00+08:00","value":0.9416},{"datetime":"2020-07-07T19:00+08:00","value":0},{"datetime":"2020-07-07T20:00+08:00","value":0},{"datetime":"2020-07-07T21:00+08:00","value":0},{"datetime":"2020-07-07T22:00+08:00","value":0},{"datetime":"2020-07-07T23:00+08:00","value":0},{"datetime":"2020-07-08T00:00+08:00","value":0},{"datetime":"2020-07-08T01:00+08:00","value":0},{"datetime":"2020-07-08T02:00+08:00","value":0},{"datetime":"2020-07-08T03:00+08:00","value":0},{"datetime":"2020-07-08T04:00+08:00","value":0},{"datetime":"2020-07-08T05:00+08:00","value":0},{"datetime":"2020-07-08T06:00+08:00","value":0},{"datetime":"2020-07-08T07:00+08:00","value":0},{"datetime":"2020-07-08T08:00+08:00","value":0}]
             * temperature : [{"datetime":"2020-07-06T09:00+08:00","value":30.16},{"datetime":"2020-07-06T10:00+08:00","value":30.97},{"datetime":"2020-07-06T11:00+08:00","value":30.77},{"datetime":"2020-07-06T12:00+08:00","value":30.58},{"datetime":"2020-07-06T13:00+08:00","value":31},{"datetime":"2020-07-06T14:00+08:00","value":31},{"datetime":"2020-07-06T15:00+08:00","value":30},{"datetime":"2020-07-06T16:00+08:00","value":30},{"datetime":"2020-07-06T17:00+08:00","value":29},{"datetime":"2020-07-06T18:00+08:00","value":28.7},{"datetime":"2020-07-06T19:00+08:00","value":27.6},{"datetime":"2020-07-06T20:00+08:00","value":27.4},{"datetime":"2020-07-06T21:00+08:00","value":26.6},{"datetime":"2020-07-06T22:00+08:00","value":26.5},{"datetime":"2020-07-06T23:00+08:00","value":26.4},{"datetime":"2020-07-07T00:00+08:00","value":26.3},{"datetime":"2020-07-07T01:00+08:00","value":26.2},{"datetime":"2020-07-07T02:00+08:00","value":26.5},{"datetime":"2020-07-07T03:00+08:00","value":26},{"datetime":"2020-07-07T04:00+08:00","value":27.5},{"datetime":"2020-07-07T05:00+08:00","value":28},{"datetime":"2020-07-07T06:00+08:00","value":28.3},{"datetime":"2020-07-07T07:00+08:00","value":28.6},{"datetime":"2020-07-07T08:00+08:00","value":29.1},{"datetime":"2020-07-07T09:00+08:00","value":29.12},{"datetime":"2020-07-07T10:00+08:00","value":29.44},{"datetime":"2020-07-07T11:00+08:00","value":31},{"datetime":"2020-07-07T12:00+08:00","value":30.5},{"datetime":"2020-07-07T13:00+08:00","value":31},{"datetime":"2020-07-07T14:00+08:00","value":31},{"datetime":"2020-07-07T15:00+08:00","value":30.92},{"datetime":"2020-07-07T16:00+08:00","value":30.74},{"datetime":"2020-07-07T17:00+08:00","value":30.47},{"datetime":"2020-07-07T18:00+08:00","value":30.02},{"datetime":"2020-07-07T19:00+08:00","value":29.31},{"datetime":"2020-07-07T20:00+08:00","value":28.64},{"datetime":"2020-07-07T21:00+08:00","value":28.04},{"datetime":"2020-07-07T22:00+08:00","value":27.69},{"datetime":"2020-07-07T23:00+08:00","value":27.26},{"datetime":"2020-07-08T00:00+08:00","value":27.03},{"datetime":"2020-07-08T01:00+08:00","value":26.78},{"datetime":"2020-07-08T02:00+08:00","value":26.55},{"datetime":"2020-07-08T03:00+08:00","value":26.68},{"datetime":"2020-07-08T04:00+08:00","value":26.83},{"datetime":"2020-07-08T05:00+08:00","value":26},{"datetime":"2020-07-08T06:00+08:00","value":27.45},{"datetime":"2020-07-08T07:00+08:00","value":27.8},{"datetime":"2020-07-08T08:00+08:00","value":28.12}]
             * wind : [{"datetime":"2020-07-06T09:00+08:00","speed":27.72,"direction":220},{"datetime":"2020-07-06T10:00+08:00","speed":2.88,"direction":273.62},{"datetime":"2020-07-06T11:00+08:00","speed":2.42,"direction":224.64},{"datetime":"2020-07-06T12:00+08:00","speed":1.11,"direction":236.15},{"datetime":"2020-07-06T13:00+08:00","speed":2.04,"direction":159},{"datetime":"2020-07-06T14:00+08:00","speed":4.32,"direction":110.5},{"datetime":"2020-07-06T15:00+08:00","speed":5.68,"direction":139.36},{"datetime":"2020-07-06T16:00+08:00","speed":1.94,"direction":178.26},{"datetime":"2020-07-06T17:00+08:00","speed":0.49,"direction":160.55},{"datetime":"2020-07-06T18:00+08:00","speed":1.01,"direction":20.17},{"datetime":"2020-07-06T19:00+08:00","speed":0.33,"direction":47.68},{"datetime":"2020-07-06T20:00+08:00","speed":1,"direction":235.32},{"datetime":"2020-07-06T21:00+08:00","speed":1.23,"direction":205.24},{"datetime":"2020-07-06T22:00+08:00","speed":2.75,"direction":160.72},{"datetime":"2020-07-06T23:00+08:00","speed":3.32,"direction":161.07},{"datetime":"2020-07-07T00:00+08:00","speed":3.19,"direction":241.98},{"datetime":"2020-07-07T01:00+08:00","speed":6.57,"direction":284.5},{"datetime":"2020-07-07T02:00+08:00","speed":6.14,"direction":271.19},{"datetime":"2020-07-07T03:00+08:00","speed":6.52,"direction":248.05},{"datetime":"2020-07-07T04:00+08:00","speed":7.26,"direction":226.23},{"datetime":"2020-07-07T05:00+08:00","speed":5.41,"direction":206.36},{"datetime":"2020-07-07T06:00+08:00","speed":3.12,"direction":210.7},{"datetime":"2020-07-07T07:00+08:00","speed":3.24,"direction":206.76},{"datetime":"2020-07-07T08:00+08:00","speed":3.41,"direction":202.98},{"datetime":"2020-07-07T09:00+08:00","speed":2.4,"direction":223.65},{"datetime":"2020-07-07T10:00+08:00","speed":2.77,"direction":297.79},{"datetime":"2020-07-07T11:00+08:00","speed":2.42,"direction":279.24},{"datetime":"2020-07-07T12:00+08:00","speed":4.27,"direction":307.68},{"datetime":"2020-07-07T13:00+08:00","speed":5.87,"direction":281.4},{"datetime":"2020-07-07T14:00+08:00","speed":7.14,"direction":254.24},{"datetime":"2020-07-07T15:00+08:00","speed":6.29,"direction":247.52},{"datetime":"2020-07-07T16:00+08:00","speed":4.51,"direction":231.76},{"datetime":"2020-07-07T17:00+08:00","speed":2.72,"direction":196.75},{"datetime":"2020-07-07T18:00+08:00","speed":4.72,"direction":177.88},{"datetime":"2020-07-07T19:00+08:00","speed":3.38,"direction":200.46},{"datetime":"2020-07-07T20:00+08:00","speed":3.08,"direction":209.05},{"datetime":"2020-07-07T21:00+08:00","speed":2.97,"direction":208.2},{"datetime":"2020-07-07T22:00+08:00","speed":3.08,"direction":249.9},{"datetime":"2020-07-07T23:00+08:00","speed":3.8,"direction":277.76},{"datetime":"2020-07-08T00:00+08:00","speed":5.26,"direction":255.04},{"datetime":"2020-07-08T01:00+08:00","speed":5.88,"direction":235.49},{"datetime":"2020-07-08T02:00+08:00","speed":5.65,"direction":232.76},{"datetime":"2020-07-08T03:00+08:00","speed":4.6,"direction":219.17},{"datetime":"2020-07-08T04:00+08:00","speed":3.57,"direction":226.79},{"datetime":"2020-07-08T05:00+08:00","speed":3.93,"direction":247.22},{"datetime":"2020-07-08T06:00+08:00","speed":4.07,"direction":237.78},{"datetime":"2020-07-08T07:00+08:00","speed":3.45,"direction":241.24},{"datetime":"2020-07-08T08:00+08:00","speed":4.17,"direction":225.19}]
             * humidity : [{"datetime":"2020-07-06T09:00+08:00","value":0.78},{"datetime":"2020-07-06T10:00+08:00","value":0.67},{"datetime":"2020-07-06T11:00+08:00","value":0.65},{"datetime":"2020-07-06T12:00+08:00","value":0.64},{"datetime":"2020-07-06T13:00+08:00","value":0.65},{"datetime":"2020-07-06T14:00+08:00","value":0.66},{"datetime":"2020-07-06T15:00+08:00","value":0.67},{"datetime":"2020-07-06T16:00+08:00","value":0.69},{"datetime":"2020-07-06T17:00+08:00","value":0.72},{"datetime":"2020-07-06T18:00+08:00","value":0.75},{"datetime":"2020-07-06T19:00+08:00","value":0.78},{"datetime":"2020-07-06T20:00+08:00","value":0.78},{"datetime":"2020-07-06T21:00+08:00","value":0.78},{"datetime":"2020-07-06T22:00+08:00","value":0.8},{"datetime":"2020-07-06T23:00+08:00","value":0.81},{"datetime":"2020-07-07T00:00+08:00","value":0.81},{"datetime":"2020-07-07T01:00+08:00","value":0.8},{"datetime":"2020-07-07T02:00+08:00","value":0.8},{"datetime":"2020-07-07T03:00+08:00","value":0.81},{"datetime":"2020-07-07T04:00+08:00","value":0.81},{"datetime":"2020-07-07T05:00+08:00","value":0.79},{"datetime":"2020-07-07T06:00+08:00","value":0.81},{"datetime":"2020-07-07T07:00+08:00","value":0.77},{"datetime":"2020-07-07T08:00+08:00","value":0.73},{"datetime":"2020-07-07T09:00+08:00","value":0.7},{"datetime":"2020-07-07T10:00+08:00","value":0.66},{"datetime":"2020-07-07T11:00+08:00","value":0.64},{"datetime":"2020-07-07T12:00+08:00","value":0.65},{"datetime":"2020-07-07T13:00+08:00","value":0.67},{"datetime":"2020-07-07T14:00+08:00","value":0.69},{"datetime":"2020-07-07T15:00+08:00","value":0.68},{"datetime":"2020-07-07T16:00+08:00","value":0.7},{"datetime":"2020-07-07T17:00+08:00","value":0.73},{"datetime":"2020-07-07T18:00+08:00","value":0.75},{"datetime":"2020-07-07T19:00+08:00","value":0.78},{"datetime":"2020-07-07T20:00+08:00","value":0.79},{"datetime":"2020-07-07T21:00+08:00","value":0.8},{"datetime":"2020-07-07T22:00+08:00","value":0.79},{"datetime":"2020-07-07T23:00+08:00","value":0.79},{"datetime":"2020-07-08T00:00+08:00","value":0.8},{"datetime":"2020-07-08T01:00+08:00","value":0.8},{"datetime":"2020-07-08T02:00+08:00","value":0.8},{"datetime":"2020-07-08T03:00+08:00","value":0.8},{"datetime":"2020-07-08T04:00+08:00","value":0.8},{"datetime":"2020-07-08T05:00+08:00","value":0.81},{"datetime":"2020-07-08T06:00+08:00","value":0.8},{"datetime":"2020-07-08T07:00+08:00","value":0.78},{"datetime":"2020-07-08T08:00+08:00","value":0.74}]
             * cloudrate : [{"datetime":"2020-07-06T09:00+08:00","value":0.9},{"datetime":"2020-07-06T10:00+08:00","value":0.9},{"datetime":"2020-07-06T11:00+08:00","value":0.88},{"datetime":"2020-07-06T12:00+08:00","value":0.91},{"datetime":"2020-07-06T13:00+08:00","value":0.94},{"datetime":"2020-07-06T14:00+08:00","value":0.88},{"datetime":"2020-07-06T15:00+08:00","value":0.93},{"datetime":"2020-07-06T16:00+08:00","value":0.96},{"datetime":"2020-07-06T17:00+08:00","value":0.96},{"datetime":"2020-07-06T18:00+08:00","value":0.85},{"datetime":"2020-07-06T19:00+08:00","value":0.88},{"datetime":"2020-07-06T20:00+08:00","value":0.9},{"datetime":"2020-07-06T21:00+08:00","value":1},{"datetime":"2020-07-06T22:00+08:00","value":1},{"datetime":"2020-07-06T23:00+08:00","value":1},{"datetime":"2020-07-07T00:00+08:00","value":1},{"datetime":"2020-07-07T01:00+08:00","value":1},{"datetime":"2020-07-07T02:00+08:00","value":1},{"datetime":"2020-07-07T03:00+08:00","value":1},{"datetime":"2020-07-07T04:00+08:00","value":0.99},{"datetime":"2020-07-07T05:00+08:00","value":0.99},{"datetime":"2020-07-07T06:00+08:00","value":0.99},{"datetime":"2020-07-07T07:00+08:00","value":0.98},{"datetime":"2020-07-07T08:00+08:00","value":0.96},{"datetime":"2020-07-07T09:00+08:00","value":1},{"datetime":"2020-07-07T10:00+08:00","value":1},{"datetime":"2020-07-07T11:00+08:00","value":1},{"datetime":"2020-07-07T12:00+08:00","value":1},{"datetime":"2020-07-07T13:00+08:00","value":1},{"datetime":"2020-07-07T14:00+08:00","value":1},{"datetime":"2020-07-07T15:00+08:00","value":1},{"datetime":"2020-07-07T16:00+08:00","value":1},{"datetime":"2020-07-07T17:00+08:00","value":1},{"datetime":"2020-07-07T18:00+08:00","value":1},{"datetime":"2020-07-07T19:00+08:00","value":1},{"datetime":"2020-07-07T20:00+08:00","value":1},{"datetime":"2020-07-07T21:00+08:00","value":1},{"datetime":"2020-07-07T22:00+08:00","value":1},{"datetime":"2020-07-07T23:00+08:00","value":1},{"datetime":"2020-07-08T00:00+08:00","value":1},{"datetime":"2020-07-08T01:00+08:00","value":1},{"datetime":"2020-07-08T02:00+08:00","value":1},{"datetime":"2020-07-08T03:00+08:00","value":1},{"datetime":"2020-07-08T04:00+08:00","value":1},{"datetime":"2020-07-08T05:00+08:00","value":1},{"datetime":"2020-07-08T06:00+08:00","value":1},{"datetime":"2020-07-08T07:00+08:00","value":1},{"datetime":"2020-07-08T08:00+08:00","value":1}]
             * skycon : [{"datetime":"2020-07-06T09:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T10:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T11:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T12:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T13:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T14:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T15:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T16:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T17:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T18:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T19:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T20:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T21:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T22:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-06T23:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T00:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T01:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T02:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T03:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T04:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T05:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T06:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T07:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T08:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T09:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T10:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T11:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T12:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T13:00+08:00","value":"MODERATE_RAIN"},{"datetime":"2020-07-07T14:00+08:00","value":"LIGHT_RAIN"},{"datetime":"2020-07-07T15:00+08:00","value":"LIGHT_RAIN"},{"datetime":"2020-07-07T16:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T17:00+08:00","value":"HEAVY_RAIN"},{"datetime":"2020-07-07T18:00+08:00","value":"MODERATE_RAIN"},{"datetime":"2020-07-07T19:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T20:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T21:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T22:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-07T23:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T00:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T01:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T02:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T03:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T04:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T05:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T06:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T07:00+08:00","value":"CLOUDY"},{"datetime":"2020-07-08T08:00+08:00","value":"CLOUDY"}]
             * pressure : [{"datetime":"2020-07-06T09:00+08:00","value":99066.5629696001},{"datetime":"2020-07-06T10:00+08:00","value":99066.5629696001},{"datetime":"2020-07-06T11:00+08:00","value":99054.9624832001},{"datetime":"2020-07-06T12:00+08:00","value":99054.9624832001},{"datetime":"2020-07-06T13:00+08:00","value":99005.5544832001},{"datetime":"2020-07-06T14:00+08:00","value":98993.9539968001},{"datetime":"2020-07-06T15:00+08:00","value":98925.5544832001},{"datetime":"2020-07-06T16:00+08:00","value":98913.9539968001},{"datetime":"2020-07-06T17:00+08:00","value":98913.9539968001},{"datetime":"2020-07-06T18:00+08:00","value":98993.9539968001},{"datetime":"2020-07-06T19:00+08:00","value":99085.5544832001},{"datetime":"2020-07-06T20:00+08:00","value":99165.5544832001},{"datetime":"2020-07-06T21:00+08:00","value":99165.5544832001},{"datetime":"2020-07-06T22:00+08:00","value":99184.2899968},{"datetime":"2020-07-06T23:00+08:00","value":99184.2899968001},{"datetime":"2020-07-07T00:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T01:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T02:00+08:00","value":99115.8904832001},{"datetime":"2020-07-07T03:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T04:00+08:00","value":99085.5544832},{"datetime":"2020-07-07T05:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T06:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T07:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T08:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T09:00+08:00","value":99306.5629696001},{"datetime":"2020-07-07T10:00+08:00","value":99294.9624832001},{"datetime":"2020-07-07T11:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T12:00+08:00","value":99233.9539968001},{"datetime":"2020-07-07T13:00+08:00","value":99214.9624832001},{"datetime":"2020-07-07T14:00+08:00","value":99153.9539968001},{"datetime":"2020-07-07T15:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T16:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T17:00+08:00","value":99085.5544832001},{"datetime":"2020-07-07T18:00+08:00","value":99104.2899968001},{"datetime":"2020-07-07T19:00+08:00","value":99165.5544832001},{"datetime":"2020-07-07T20:00+08:00","value":99226.5629696001},{"datetime":"2020-07-07T21:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T22:00+08:00","value":99245.5544832001},{"datetime":"2020-07-07T23:00+08:00","value":99245.5544832001},{"datetime":"2020-07-08T00:00+08:00","value":99165.5544832001},{"datetime":"2020-07-08T01:00+08:00","value":99085.5544832001},{"datetime":"2020-07-08T02:00+08:00","value":99035.8904832001},{"datetime":"2020-07-08T03:00+08:00","value":99005.5544832001},{"datetime":"2020-07-08T04:00+08:00","value":99005.5544832001},{"datetime":"2020-07-08T05:00+08:00","value":99035.8904832001},{"datetime":"2020-07-08T06:00+08:00","value":99085.5544832},{"datetime":"2020-07-08T07:00+08:00","value":99115.8904832001},{"datetime":"2020-07-08T08:00+08:00","value":99085.5544832001}]
             * visibility : [{"datetime":"2020-07-06T09:00+08:00","value":16},{"datetime":"2020-07-06T10:00+08:00","value":16},{"datetime":"2020-07-06T11:00+08:00","value":16},{"datetime":"2020-07-06T12:00+08:00","value":16},{"datetime":"2020-07-06T13:00+08:00","value":16},{"datetime":"2020-07-06T14:00+08:00","value":16},{"datetime":"2020-07-06T15:00+08:00","value":16},{"datetime":"2020-07-06T16:00+08:00","value":16},{"datetime":"2020-07-06T17:00+08:00","value":13.91},{"datetime":"2020-07-06T18:00+08:00","value":10.43},{"datetime":"2020-07-06T19:00+08:00","value":8.8},{"datetime":"2020-07-06T20:00+08:00","value":8.71},{"datetime":"2020-07-06T21:00+08:00","value":8.68},{"datetime":"2020-07-06T22:00+08:00","value":8.18},{"datetime":"2020-07-06T23:00+08:00","value":7.5},{"datetime":"2020-07-07T00:00+08:00","value":7.47},{"datetime":"2020-07-07T01:00+08:00","value":8.04},{"datetime":"2020-07-07T02:00+08:00","value":7.89},{"datetime":"2020-07-07T03:00+08:00","value":7.66},{"datetime":"2020-07-07T04:00+08:00","value":7.66},{"datetime":"2020-07-07T05:00+08:00","value":8.24},{"datetime":"2020-07-07T06:00+08:00","value":7.74},{"datetime":"2020-07-07T07:00+08:00","value":9.14},{"datetime":"2020-07-07T08:00+08:00","value":11.92},{"datetime":"2020-07-07T09:00+08:00","value":16},{"datetime":"2020-07-07T10:00+08:00","value":16},{"datetime":"2020-07-07T11:00+08:00","value":16},{"datetime":"2020-07-07T12:00+08:00","value":16},{"datetime":"2020-07-07T13:00+08:00","value":16},{"datetime":"2020-07-07T14:00+08:00","value":16},{"datetime":"2020-07-07T15:00+08:00","value":16},{"datetime":"2020-07-07T16:00+08:00","value":16},{"datetime":"2020-07-07T17:00+08:00","value":12.5},{"datetime":"2020-07-07T18:00+08:00","value":10.55},{"datetime":"2020-07-07T19:00+08:00","value":9.09},{"datetime":"2020-07-07T20:00+08:00","value":8.36},{"datetime":"2020-07-07T21:00+08:00","value":8.19},{"datetime":"2020-07-07T22:00+08:00","value":8.36},{"datetime":"2020-07-07T23:00+08:00","value":8.36},{"datetime":"2020-07-08T00:00+08:00","value":8.08},{"datetime":"2020-07-08T01:00+08:00","value":8.05},{"datetime":"2020-07-08T02:00+08:00","value":7.86},{"datetime":"2020-07-08T03:00+08:00","value":8.17},{"datetime":"2020-07-08T04:00+08:00","value":8.02},{"datetime":"2020-07-08T05:00+08:00","value":7.69},{"datetime":"2020-07-08T06:00+08:00","value":7.89},{"datetime":"2020-07-08T07:00+08:00","value":8.68},{"datetime":"2020-07-08T08:00+08:00","value":11.14}]
             * dswrf : [{"datetime":"2020-07-06T09:00+08:00","value":627.6260608},{"datetime":"2020-07-06T10:00+08:00","value":672.082304},{"datetime":"2020-07-06T11:00+08:00","value":721.56717824},{"datetime":"2020-07-06T12:00+08:00","value":769.26651136},{"datetime":"2020-07-06T13:00+08:00","value":782.08937216},{"datetime":"2020-07-06T14:00+08:00","value":808.38138368},{"datetime":"2020-07-06T15:00+08:00","value":732.9398784},{"datetime":"2020-07-06T16:00+08:00","value":643.8418176},{"datetime":"2020-07-06T17:00+08:00","value":547.6338176},{"datetime":"2020-07-06T18:00+08:00","value":455.2178176},{"datetime":"2020-07-06T19:00+08:00","value":370.4918784},{"datetime":"2020-07-06T20:00+08:00","value":306.71149056},{"datetime":"2020-07-06T21:00+08:00","value":0},{"datetime":"2020-07-06T22:00+08:00","value":0},{"datetime":"2020-07-06T23:00+08:00","value":0},{"datetime":"2020-07-07T00:00+08:00","value":0},{"datetime":"2020-07-07T01:00+08:00","value":0},{"datetime":"2020-07-07T02:00+08:00","value":0},{"datetime":"2020-07-07T03:00+08:00","value":0},{"datetime":"2020-07-07T04:00+08:00","value":0},{"datetime":"2020-07-07T05:00+08:00","value":0},{"datetime":"2020-07-07T06:00+08:00","value":10},{"datetime":"2020-07-07T07:00+08:00","value":40},{"datetime":"2020-07-07T08:00+08:00","value":98.2096},{"datetime":"2020-07-07T09:00+08:00","value":609.1821824},{"datetime":"2020-07-07T10:00+08:00","value":699.1181824},{"datetime":"2020-07-07T11:00+08:00","value":750.73400064},{"datetime":"2020-07-07T12:00+08:00","value":782.14021888},{"datetime":"2020-07-07T13:00+08:00","value":791.15077632},{"datetime":"2020-07-07T14:00+08:00","value":773.29339392},{"datetime":"2020-07-07T15:00+08:00","value":558.0382976},{"datetime":"2020-07-07T16:00+08:00","value":480.1105408},{"datetime":"2020-07-07T17:00+08:00","value":416.489088},{"datetime":"2020-07-07T18:00+08:00","value":343.1912704},{"datetime":"2020-07-07T19:00+08:00","value":282.267392},{"datetime":"2020-07-07T20:00+08:00","value":235.35393792},{"datetime":"2020-07-07T21:00+08:00","value":0},{"datetime":"2020-07-07T22:00+08:00","value":0},{"datetime":"2020-07-07T23:00+08:00","value":0},{"datetime":"2020-07-08T00:00+08:00","value":0},{"datetime":"2020-07-08T01:00+08:00","value":0},{"datetime":"2020-07-08T02:00+08:00","value":0},{"datetime":"2020-07-08T03:00+08:00","value":0},{"datetime":"2020-07-08T04:00+08:00","value":0},{"datetime":"2020-07-08T05:00+08:00","value":0},{"datetime":"2020-07-08T06:00+08:00","value":7.6260608},{"datetime":"2020-07-08T07:00+08:00","value":28.5499392},{"datetime":"2020-07-08T08:00+08:00","value":61.5773696}]
             * air_quality : {"aqi":[{"datetime":"2020-07-06T09:00+08:00","value":{"chn":13,"usa":13}},{"datetime":"2020-07-06T10:00+08:00","value":{"chn":11,"usa":11}},{"datetime":"2020-07-06T11:00+08:00","value":{"chn":9,"usa":9}},{"datetime":"2020-07-06T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T15:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T16:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T17:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T18:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T19:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T20:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-06T21:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T22:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-06T23:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T00:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T01:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T02:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T03:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T04:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T05:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T06:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T07:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T08:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T09:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T10:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T11:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T12:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T13:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T14:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T15:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T16:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T17:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T18:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T19:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T20:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-07T21:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T22:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-07T23:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T00:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T01:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T02:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T03:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T04:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T05:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T06:00+08:00","value":{"chn":8,"usa":8}},{"datetime":"2020-07-08T07:00+08:00","value":{"chn":7,"usa":7}},{"datetime":"2020-07-08T08:00+08:00","value":{"chn":7,"usa":7}}],"pm25":[{"datetime":"2020-07-06T09:00+08:00","value":6},{"datetime":"2020-07-06T10:00+08:00","value":5},{"datetime":"2020-07-06T11:00+08:00","value":4},{"datetime":"2020-07-06T12:00+08:00","value":4},{"datetime":"2020-07-06T13:00+08:00","value":3},{"datetime":"2020-07-06T14:00+08:00","value":3},{"datetime":"2020-07-06T15:00+08:00","value":4},{"datetime":"2020-07-06T16:00+08:00","value":4},{"datetime":"2020-07-06T17:00+08:00","value":4},{"datetime":"2020-07-06T18:00+08:00","value":3},{"datetime":"2020-07-06T19:00+08:00","value":3},{"datetime":"2020-07-06T20:00+08:00","value":3},{"datetime":"2020-07-06T21:00+08:00","value":4},{"datetime":"2020-07-06T22:00+08:00","value":4},{"datetime":"2020-07-06T23:00+08:00","value":4},{"datetime":"2020-07-07T00:00+08:00","value":4},{"datetime":"2020-07-07T01:00+08:00","value":3},{"datetime":"2020-07-07T02:00+08:00","value":3},{"datetime":"2020-07-07T03:00+08:00","value":4},{"datetime":"2020-07-07T04:00+08:00","value":3},{"datetime":"2020-07-07T05:00+08:00","value":3},{"datetime":"2020-07-07T06:00+08:00","value":4},{"datetime":"2020-07-07T07:00+08:00","value":4},{"datetime":"2020-07-07T08:00+08:00","value":4},{"datetime":"2020-07-07T09:00+08:00","value":3},{"datetime":"2020-07-07T10:00+08:00","value":3},{"datetime":"2020-07-07T11:00+08:00","value":3},{"datetime":"2020-07-07T12:00+08:00","value":3},{"datetime":"2020-07-07T13:00+08:00","value":4},{"datetime":"2020-07-07T14:00+08:00","value":4},{"datetime":"2020-07-07T15:00+08:00","value":4},{"datetime":"2020-07-07T16:00+08:00","value":3},{"datetime":"2020-07-07T17:00+08:00","value":3},{"datetime":"2020-07-07T18:00+08:00","value":4},{"datetime":"2020-07-07T19:00+08:00","value":4},{"datetime":"2020-07-07T20:00+08:00","value":4},{"datetime":"2020-07-07T21:00+08:00","value":4},{"datetime":"2020-07-07T22:00+08:00","value":5},{"datetime":"2020-07-07T23:00+08:00","value":5},{"datetime":"2020-07-08T00:00+08:00","value":4},{"datetime":"2020-07-08T01:00+08:00","value":4},{"datetime":"2020-07-08T02:00+08:00","value":4},{"datetime":"2020-07-08T03:00+08:00","value":5},{"datetime":"2020-07-08T04:00+08:00","value":4},{"datetime":"2020-07-08T05:00+08:00","value":4},{"datetime":"2020-07-08T06:00+08:00","value":5},{"datetime":"2020-07-08T07:00+08:00","value":5},{"datetime":"2020-07-08T08:00+08:00","value":5}]}
             */

            private String status;
            private String description;
            private AirQualityBean air_quality;
            private List<PrecipitationBean> precipitation;
            private List<TemperatureBean> temperature;
            private List<WindBean> wind;
            private List<HumidityBean> humidity;
            private List<CloudrateBean> cloudrate;
            private List<SkyconBean> skycon;
            private List<PressureBean> pressure;
            private List<VisibilityBean> visibility;
            private List<DswrfBean> dswrf;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<PressureBean> getPressure() {
                return pressure;
            }

            public void setPressure(List<PressureBean> pressure) {
                this.pressure = pressure;
            }

            public List<VisibilityBean> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityBean> visibility) {
                this.visibility = visibility;
            }

            public List<DswrfBean> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfBean> dswrf) {
                this.dswrf = dswrf;
            }

            public static class AirQualityBean {
                private List<AqiBean> aqi;
                private List<Pm25Bean> pm25;

                public List<AqiBean> getAqi() {
                    return aqi;
                }

                public void setAqi(List<AqiBean> aqi) {
                    this.aqi = aqi;
                }

                public List<Pm25Bean> getPm25() {
                    return pm25;
                }

                public void setPm25(List<Pm25Bean> pm25) {
                    this.pm25 = pm25;
                }

                public static class AqiBean {
                    /**
                     * datetime : 2020-07-06T09:00+08:00
                     * value : {"chn":13,"usa":13}
                     */

                    private String datetime;
                    private ValueBean value;

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }

                    public ValueBean getValue() {
                        return value;
                    }

                    public void setValue(ValueBean value) {
                        this.value = value;
                    }

                    public static class ValueBean {
                        /**
                         * chn : 13
                         * usa : 13
                         */

                        private int chn;
                        private int usa;

                        public int getChn() {
                            return chn;
                        }

                        public void setChn(int chn) {
                            this.chn = chn;
                        }

                        public int getUsa() {
                            return usa;
                        }

                        public void setUsa(int usa) {
                            this.usa = usa;
                        }
                    }
                }

                public static class Pm25Bean {
                    /**
                     * datetime : 2020-07-06T09:00+08:00
                     * value : 6
                     */

                    private String datetime;
                    private int value;

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }
            }

            public static class PrecipitationBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : 0.0
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class TemperatureBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : 30.16
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class WindBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * speed : 27.72
                 * direction : 220.0
                 */

                private String datetime;
                private double speed;
                private double direction;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }

                public double getDirection() {
                    return direction;
                }

                public void setDirection(double direction) {
                    this.direction = direction;
                }
            }

            public static class HumidityBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : 0.78
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class CloudrateBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : 0.9
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class SkyconBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : CLOUDY
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class PressureBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : 99066.5629696001
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class VisibilityBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : 16.0
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class DswrfBean {
                /**
                 * datetime : 2020-07-06T09:00+08:00
                 * value : 627.6260608
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }
        }
    }
}
