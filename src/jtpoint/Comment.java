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
class Comment {
    String user;
    String com;
    int id;
    public Comment(int id,String user,String com)
    {   this.id=id;
        this.com=com;
        this.user=user;
    }
    @Override
    public String toString()
    {
        return this.user+" "+" :- "+" "+this.com;
    }
    
}
