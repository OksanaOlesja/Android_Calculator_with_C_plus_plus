package com.example.calculator;

import androidx.annotation.NonNull;

import java.sql.Array;
import java.util.ArrayList;

public class PolishRecord {
    private int prioritet(char a)
    {
        switch (a)
        {
            case '*':return 2;
            case '/':return 2;
            case '+':return 1;
            case '-':return 1;
            default:return 0;
        }
    }
    public ArrayList<String> syfics(@NonNull String mas) {

        ArrayList<Character> myints=new ArrayList<Character>();
        ArrayList<String> rezult=new ArrayList<String>();

        StringBuilder operand = new StringBuilder();
        for (int i = 0; i < mas.length(); i++)
        {


            if (mas.charAt(i)== '*' || mas.charAt(i)== '/' || mas.charAt(i)== '+' || mas.charAt(i)== '-')
            {
                if(operand.length()!=0) {
                    rezult.add(operand.toString());
                    operand = new StringBuilder();
                }
                boolean test = true;
                while (test)
                {

                    if (!myints.isEmpty())
                    {
                        if (prioritet(mas.charAt(i)) <= prioritet(myints.get(myints.size()-1)))
                        {
                            rezult.add((myints.get(myints.size()-1)).toString());
                            myints.remove(myints.size()-1);

                        }
                        else
                        {
                            myints.add(mas.charAt(i));
                            test = false;
                        }
                    }
                    else
                    {
                        myints.add(mas.charAt(i));
                        test = false;
                    }
                }
            }



            if (mas.charAt(i) == '(')
            {
                myints.add(mas.charAt(i));
                operand = new StringBuilder();
            }
            if (mas.charAt(i) == ')')
            {
                rezult.add(operand.toString());
                operand = new StringBuilder();
                while (myints.get(myints.size()-1) != '(')
                {
                    rezult.add(myints.get(myints.size()-1).toString());
                    myints.remove(myints.size()-1);
                }
                myints.remove(myints.size()-1);

            }

            if((mas.charAt(i) != '*') && (mas.charAt(i) != '/') && (mas.charAt(i) != '+') && (mas.charAt(i) != '-') && (mas.charAt(i) != '(') && (mas.charAt(i) != ')'))
            {
//                rezult.add(Character.toString(mas.charAt(i)));

                operand.append(mas.charAt(i));
            }

        }
        if(operand.length()!=0) {
            rezult.add(operand.toString());
        }

        while (!myints.isEmpty())
        {
            rezult.add(myints.get(myints.size()-1).toString());
            myints.remove(myints.size()-1);
        }
        return rezult;
    }

    public double rachunok(double first, double second , char  a)
    {
        switch (a)
        {
            case '*':return second* first;
            case '/':return first / second;
            case '+':return second + first;
            case '-':return first - second;
            default:return 0;
        }
    }



    public double obchuslutu(ArrayList<String> rezult)
    {
        //ArrayList<Character> myints=new ArrayList<Character>();
        ArrayList<String> myints=new ArrayList<String>();
        for (int i = 0; i < rezult.size(); i++)
        {
            if (rezult.get(i).charAt(0) != '*' && rezult.get(i).charAt(0) != '/' &&
                    rezult.get(i).charAt(0) != '+' && rezult.get(i).charAt(0) != '-' )
            {
//                myints.add((char)(Integer.parseInt(rezult.get(i)) - 48));
                myints.add(rezult.get(i));
            }
            else
            {
                if (!myints.isEmpty())
                {
                    double first, second;
                    //second=myints.get(myints.size()-1);
                    second=Double.parseDouble(myints.get(myints.size()-1));
                    myints.remove(myints.size()-1);
                    //first = myints.get(myints.size()-1);
                    first = Double.parseDouble(myints.get(myints.size()-1));
                    myints.remove(myints.size()-1);
                    myints.add(Double.toString(rachunok(first, second,rezult.get(i).charAt(0))));
                }

            }

        }
        //return myints.get(myints.size()-1);
        return Double.parseDouble(myints.get(myints.size()-1));
        //myints.remove(myints.size()-1);

    }
}
