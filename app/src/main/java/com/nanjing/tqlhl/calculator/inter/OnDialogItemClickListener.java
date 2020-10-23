package com.nanjing.tqlhl.calculator.inter;


import com.nanjing.tqlhl.calculator.bean.DWBean;

import java.util.HashMap;

public interface OnDialogItemClickListener {

 public  void  ItemClick(HashMap<String, String> item, int clickId);

 public  void  ItemClick(int clickId, HashMap<String, DWBean> item);



}
