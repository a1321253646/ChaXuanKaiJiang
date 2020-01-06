package com.sscparse.string.utils;

import java.util.Calendar;

public class NowIndex {
	public static final Integer[][] mTimeLsit ={
            {0,5},{0,10},{0,15},{0,20},{0,25},{0,30},{0,35},{0,40},{0,45},{0,50},{0,55},{1,0},
            {1,5},{1,10},{1,15},{1,20},{1,25},{1,30},{1,35},{1,40},{1,45},{1,50},{1,55},
            {10,0},{10,10},{10,20},{10,30},{10,40},{10,50},
            {11,0},{11,10},{11,20},{11,30},{11,40},{11,50},
            {12,0},{12,10},{12,20},{12,30},{12,40},{12,50},
            {13,0},{13,10},{13,20},{13,30},{13,40},{13,50},
            {14,0},{14,10},{14,20},{14,30},{14,40},{14,50},
            {15,0},{15,10},{15,20},{15,30},{15,40},{15,50},
            {16,0},{16,10},{16,20},{16,30},{16,40},{16,50},
            {17,0},{17,10},{17,20},{17,30},{17,40},{17,50},
            {18,0},{18,10},{18,20},{18,30},{18,40},{18,50},
            {19,0},{19,10},{19,20},{19,30},{19,40},{19,50},
            {20,0},{20,10},{20,20},{20,30},{20,40},{20,50},
            {21,0},{21,10},{21,20},{21,30},{21,40},{21,50},
            {22,0},{22,5},{22,10},{22,15},{22,20},{22,25},{22,30},{22,35},{22,40},{22,45},{22,50},{22,55},
            {23,0},{23,5},{23,10},{23,15},{23,20},{23,25},{23,30},{23,35},{23,40},{23,45},{23,50},{23,55},{24,0},
    } ;
	
	public static int getNowInde() {
		Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return getIndex(hour,minute);
		
	}
    private static  int getIndex(int hour , int min){
        Integer[] time;
        if(hour == 0 && min == 0){
           // isOpen =true;
            return mTimeLsit.length;
        }
        for(int i = 0 ; i<mTimeLsit.length;i++){
            time = mTimeLsit[i];
            if(time[0]  == hour  || (time[0] ==24 && hour ==0) ){
                if(time[1] <min){
                    continue;
                }else if(time[1] == min){
                   // isOpen = true;
                    return i+1;
                }else{
                   // isOpen = false;
                    return i;
                }
            }else if(hour < time[0]){
               // isOpen = false;
                return i;
            }else{
                continue;
            }
        }
        return 0;
    }
}
