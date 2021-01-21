//package com.bmsoft.dmp.common.util;
//
//import com.atqgh.micro.common.exception.ResultException;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.http.HttpStatus;
//
//import java.lang.reflect.Field;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author lizihao
// * @version 1.0
// * @date 2020/3/16 17:27
// */
//public class BeanUtil {
//    public static final String DEL="del";
//    public static final String UPDATE="update";
//    public static final String ADD="add";
//
//    public static <T> T copy(Object obj, Class<T> clz) {
//        try {
//            T e = clz.newInstance();
//            BeanUtils.copyProperties(obj, e);
//            return e;
//        } catch (Exception e1) {
//            throw new ResultException(HttpStatus.INTERNAL_SERVER_ERROR.value(),e1.toString());
//        }
//    }
//
//    /**
//     * 将list按照fieldArr转成map
//     * @param rows
//     * @param fieldArr
//     * @param <T>
//     * @return
//     */
//    public static <T> Map<String,T> listToMapT(List<T> rows, String... fieldArr){
//
//        Map<String,T> map= Maps.newHashMap();
//        if(CollectionUtils.isEmpty(rows)){
//            return map;
//        }
//        //利用反射将list按一定的规则转成map
//        for (T t:rows
//        ) {
//            if(t==null){
//                continue;
//            }
//            Class clazz= t.getClass();
//            StringBuffer key=new StringBuffer();
//            try {
//                for (String fieldStr:fieldArr
//                ) {
//
//                    Field field= clazz.getDeclaredField(fieldStr);
//                    field.setAccessible(true);
//                    Object value=field.get(t);
//                    key.append(value+"_");
//                }
//
//                map.put(key.substring(0,key.length()-1),t);
//            } catch (Exception e) {
//                System.out.println("........"+rows+fieldArr);
//                e.printStackTrace();
//                continue;
//            }
//
//        }
//        return map;
//    }
//    public static  <T> Map<String,List<T>> compareMap(List<T> tList,List<T> sourceList,String fieldId){
//        Map<String,List<T>> resultMap= Maps.newHashMap();
//        if(org.springframework.util.CollectionUtils.isEmpty(sourceList)){
//            resultMap.put(ADD,tList);
//            return resultMap;
//        }
//        if(org.springframework.util.CollectionUtils.isEmpty(tList)){
//            resultMap.put(DEL,sourceList);
//            return resultMap;
//        }
//        Class clazz= tList.get(0).getClass();
//        Map<String, T> sourceMap = BeanUtil.listToMapT(sourceList, fieldId);
//        List<T> updateT= Lists.newArrayList();
//        List<T> addT=Lists.newArrayList();
//        try {
//            for (T t:tList
//            ) {
//                Field field= clazz.getDeclaredField(fieldId);
//                field.setAccessible(true);
//                Object value=field.get(t);
//                String key=String.valueOf(value);
//                if(StringUtils.isNotBlank(key)&&sourceMap.containsKey(key)){
//                    updateT.add(t);
//                    sourceList.remove(sourceMap.get(key));
//                }else{
//                    addT.add(t);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        resultMap.put(DEL,sourceList);
//        resultMap.put(UPDATE,updateT);
//        resultMap.put(ADD,addT);
//        return resultMap;
//    }
//}
