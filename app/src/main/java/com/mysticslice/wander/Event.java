package com.mysticslice.wander;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    private String mEventName;
    private String mLocation;
    private String mUrl;
    private String mDate;
    private String mDay;
    private String mCategory;

    public Event(){

    }

    /**
     * Object containing all info about an event
     * @param EventName Name of the event
     * @param Location Location of the event
     * @param Date Date of event
     * @param Url Url of the event website
     */
    public Event(String EventName, String Location, String Date,String Category, String Url,String Day){
        mEventName = EventName;
        mLocation = Location;
        mDate = Date;
        mUrl = Url;
        mCategory = Category;

        if(Day == null){
            try{
                SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
                Date dt1 = format1.parse(Date);
                DateFormat format2=new SimpleDateFormat("EE");
                mDay =format2.format(dt1);
            }catch (ParseException e){
                e.printStackTrace();
                mDay = "Error";
            }
        }
        else{
            mDay = Day;
        }



    }

    public String getEventName() {
        return mEventName;
    }

    public void setEventName(String EventName) {
        this.mEventName = EventName;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String Location) {
        this.mLocation = Location;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String Url) {
        this.mUrl = Url;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String Date) {
        this.mDate = Date;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String Day) {
        this.mDay = Day;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }
}
