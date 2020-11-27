/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obo.util;

/**
 *
 * @author elmonazareno
 */
public class TimeFormat {
    
    public static String format( Object  o ) {
        if(o == null ) return "";
        int n = Integer.parseInt(o.toString());
        int d = (int) (n/86400);
        int h = (int)  ((n % 86400) / 3600);
        int m = (int) ((n % 3600) /60  );
        int s = (int) (n % 60);
        StringBuilder sb = new StringBuilder();
        if(d>0) sb.append( d + " days ");
        if(h>0) sb.append( h + " hrs ");
        if(m>0) sb.append( m+ " mins ");
        if(s>0) sb.append( s + " sec ");
        return sb.toString();
    }
}
