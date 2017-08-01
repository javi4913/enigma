/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author David
 */
public class QampA {
    private String subject;
    private String question;
    private ArrayList<String> options;
    private ArrayList<String> fourOptions;
    private String answer;

    public QampA(String subject, String question, ArrayList<String> options, String answer) {
        this.subject = subject;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public QampA() {
        fourOptions = new ArrayList<>();
    }
    
    public String isCorrect(String option){
        return answer.equals(option) ? "Correcta" : "Incorrecta";
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getFourOptions() {
        return fourOptions;
    }
    
    
    @Override
    public String toString(){
        return String.format("%s\n¿%s?\n%s",this.subject,this.question,this.getRandomOption());
    }
    private String getRandomOption(){
        Random r = new Random();
        StringBuilder ret = new StringBuilder();
        int j = 0;
        String mark, option;
        for (int i = 0; i < 4; ) {
            option = this.options.get(Math.abs(r.nextInt()%this.options.size()));
            if(!this.fourOptions.contains(option)){
                if(i == 3 && !this.fourOptions.contains(this.answer)){
                    option = this.answer;
                }
                this.fourOptions.add(option);
                j++;
                mark = (option.equalsIgnoreCase(this.answer) ? "+ " : "- ");
                ret.append("\t").append(j).append(mark).append(option).append("\n");
                i++;
            }
        }
        
        return ret.toString();
    }
    
}
