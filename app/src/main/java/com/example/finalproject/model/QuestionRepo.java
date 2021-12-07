package com.example.finalproject.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepo {
    public List<Questions> getListQuestions(){
        return new ArrayList<Questions>(){{
            add(new Questions("5 * 7","35"));
            add(new Questions("47 + 33","80"));
            add(new Questions("45 - 23","22"));
            add(new Questions("84 / 12","7"));


        }

        };
    }
}
