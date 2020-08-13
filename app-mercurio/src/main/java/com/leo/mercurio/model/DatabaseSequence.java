package com.leo.mercurio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* collection that'll store the auto-incremented sequence for other collections
*
* */
@Document(collection = "employees")
public class DatabaseSequence {
    @Id
    private String id;

    private long seq;

    public DatabaseSequence(){}

    public String getIt(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setSeq(long seq){
        this.seq = seq;
    }

    public long getSeq(){
        return seq;
    }
}
