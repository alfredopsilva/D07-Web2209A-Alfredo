/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package silva.stocks.utility;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author alfredoparreira
 */
public class CurrencyHelper {
    
    private CurrencyHelper(){}
    
    public static NumberFormat getCurrencyFormatter()
    {
        return getCurrencyFormatter(Locale.getDefault());
    }
    
    public static NumberFormat getCurrencyFormatter(Locale locale)
    {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return format;
    }
}
