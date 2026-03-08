package com.oca.practice;

public class Practice{
    public static void main(String args[]){

        int[] arr = {1,2,3,4,5};
        
        String a = "cvdec";

        String[] str_arr = {"red","brown","black","blue","white"};

        //str_arr[5] = "yellow";

        for(int i =0; i < str_arr.length ; i++){
            for(int j : str_arr[i].toCharArray()){
                System.out.println(j);
            }
        }



        

           
    }
}