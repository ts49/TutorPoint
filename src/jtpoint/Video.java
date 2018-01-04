/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtpoint;

/**
 *
 * @author absolute49
 */
public class Video {

    private final int videoid;
    private final String byuser;
    private final int likes;
    private final String path;
    private final String subject;
    private final String topic;
    private final String heading;
  //  public final Comment[] comments;
    
    public Video(int videoid,String byuser,String path,String subject ,String topic,int likes,String heading)
    {
        this.videoid=videoid;
        this.byuser=byuser;
        this.likes=likes;
        this.path=path;
        this.subject=subject;
        this.topic=topic;
        this.heading=heading;
        
        
    }
    public int videoid()
    {
        return this.videoid;
    }
    public String byuser()
    {
        return this.byuser;
        
    }
    public String path()
    {
        return this.path;
        
    }
    public String subject()
    {
        return this.subject;
    }
    public String topic()
    {
        return this.topic;
    }
    public int likes()
    {
        return this.likes;
    }
    public String heading()
    {
        return this.heading;
    }
    @Override
    public String toString()
    {
        return this.heading+","+this.topic+" ("+""+this.subject+" )"+" By "+" "+this.byuser;
    }
}
