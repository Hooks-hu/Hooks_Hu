/**
 *
 */
package com.myapplication.utils;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StrikethroughSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.myapplication.base.BaseConst;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 注�?
 * </p>
 *
 * @author Frank.fan
 * @version $Id: TaxStringUtil.java, v 0.1 2011-5-5 �??01:43:01 fanmanrong Exp $
 */
public class StringUtil {

	/*
     * ==========================================================================
	 * ==
	 */
    /* 常�???ingleton?? */
    /*
	 * ==========================================================================
	 * ==
	 */

    /**
     * 空�?�?��??
     */
    public static final String EMPTY_STRING = "";

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ?�空?��??? */
	/*                                                                              */
	/* 以�??��??��??��?�?���??串�???���? */
	/* 1. null */
	/* 2. empty - "" */
	/* 3. blank - "?��???��?? - 空�???haracter.isWhitespace???�?? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??�??串�???��<code>null</code>??���??�?code>""</code>??
     * <p/>
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??为空, ?????code>true</code>
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    /**
     * �??�??串�??????code>null</code>??���??�?code>""</code>??
     * <p/>
     * <pre>
     * StringUtil.isEmpty(null)      = false
     * StringUtil.isEmpty("")        = false
     * StringUtil.isEmpty(" ")       = true
     * StringUtil.isEmpty("bob")     = true
     * StringUtil.isEmpty("  bob  ") = true
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�?���? ?????code>true</code>
     */
    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }

    /**
     * �??�??串�????空�?�?code>null</code>??���??�?code>""</code>?????��?��?�??
     * <p/>
     * <pre>
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank("")        = true
     * StringUtil.isBlank(" ")       = true
     * StringUtil.isBlank("bob")     = false
     * StringUtil.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??为空?? ?????code>true</code>
     */
    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static String getFace(String uri,String url){
        String res = null;
        if(!TextUtils.isEmpty(uri) && uri.startsWith("http://")){
            res = uri;
        }else{
            if(TextUtils.isEmpty(uri)){
                return res;
            }else{
                if(TextUtils.isEmpty(url)){
                    url = BaseConst.BASE_SERVER_ENTRY;
                }else{
                }
                if (uri.contains("./")){
                    res=url+uri.replace("./","/");
                }else{
                    res=url+uri;
                }
            }
        }
        return res;
    }

    /**
     * �??�??串�??????��?��?<code>null</code>
     * ??���??�?code>""</code>?????��?��?�??
     * <p/>
     * <pre>
     * StringUtil.isBlank(null)      = false
     * StringUtil.isBlank("")        = false
     * StringUtil.isBlank(" ")       = false
     * StringUtil.isBlank("bob")     = true
     * StringUtil.isBlank("  bob  ") = true
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??为空?? ?????code>true</code>
     */
    public static boolean isNotBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �???��??��? */
	/*                                                                              */
	/* �??�?���?ull??mpty??lank?��?�??�?���?????�??�??�??串�? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??�??串�?<code>null</code>�??�??空�?�?��<code>""</code>�????????�?��??��??
     * <p/>
     * <pre>
     * StringUtil.defaultIfNull(null)  = ""
     * StringUtil.defaultIfNull("")    = ""
     * StringUtil.defaultIfNull("  ")  = "  "
     * StringUtil.defaultIfNull("bat") = "bat"
     * </pre>
     *
     * @param str �?��?��?�??�?
     * @return �??串�?�??空�?�?��<code>""</code>
     */
    public static String defaultIfNull(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    /**
     * �??�??串�?<code>null</code>�??�?????�??�??串�????�??�??串�?�??
     * <p/>
     * <pre>
     * StringUtil.defaultIfNull(null, "default")  = "default"
     * StringUtil.defaultIfNull("", "default")    = ""
     * StringUtil.defaultIfNull("  ", "default")  = "  "
     * StringUtil.defaultIfNull("bat", "default") = "bat"
     * </pre>
     *
     * @param str        �?��?��?�??�?
     * @param defaultStr �??�??�?
     * @return �??串�?�????????认�?�?��
     */
    public static String defaultIfNull(String str, String defaultStr) {
        return (str == null) ? defaultStr : str;
    }

    /**
     * �??�??串�?<code>null</code>??���??�?code>""</code>�??�??空�?�?��
     * <code>""</code>�????????�?��??��??
     * <p/>
     * <p>
     * 此�?�???????code>defaultIfNull(String)</code>�????
     * <p/>
     * <pre>
     * StringUtil.defaultIfEmpty(null)  = ""
     * StringUtil.defaultIfEmpty("")    = ""
     * StringUtil.defaultIfEmpty("  ")  = "  "
     * StringUtil.defaultIfEmpty("bat") = "bat"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?��?��?�??�?
     * @return �??串�?�??空�?�?��<code>""</code>
     */
    public static String defaultIfEmpty(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    /**
     * �??�??串�?<code>null</code>
     * ??���??�?code>""</code>�??�?????�??�??串�????�??�??串�?�??
     * <p/>
     * <pre>
     * StringUtil.defaultIfEmpty(null, "default")  = "default"
     * StringUtil.defaultIfEmpty("", "default")    = "default"
     * StringUtil.defaultIfEmpty("  ", "default")  = "  "
     * StringUtil.defaultIfEmpty("bat", "default") = "bat"
     * </pre>
     *
     * @param str        �?��?��?�??�?
     * @param defaultStr �??�??�?
     * @return �??串�?�????????认�?�?��
     */
    public static String defaultIfEmpty(String str, String defaultStr) {
        return ((str == null) || (str.length() == 0)) ? defaultStr : str;
    }

    /**
     * �??�??串�?空�?�?code>null</code>??���??�?code>""</code>?????��?��?�???????�
     * ��?? �?code>""</code>�????????�?��??��??
     * <p/>
     * <pre>
     * StringUtil.defaultIfBlank(null)  = ""
     * StringUtil.defaultIfBlank("")    = ""
     * StringUtil.defaultIfBlank("  ")  = ""
     * StringUtil.defaultIfBlank("bat") = "bat"
     * </pre>
     *
     * @param str �?��?��?�??�?
     * @return �??串�?�??空�?�?��<code>""</code>
     */
    public static String defaultIfBlank(String str) {
        return isBlank(str) ? EMPTY_STRING : str;
    }

    /**
     * �??�??串�?<code>null</code>
     * ??���??�?code>""</code>�??�?????�??�??串�????�??�??串�?�??
     * <p/>
     * <pre>
     * StringUtil.defaultIfBlank(null, "default")  = "default"
     * StringUtil.defaultIfBlank("", "default")    = "default"
     * StringUtil.defaultIfBlank("  ", "default")  = "default"
     * StringUtil.defaultIfBlank("bat", "default") = "bat"
     * </pre>
     *
     * @param str        �?��?��?�??�?
     * @param defaultStr �??�??�?
     * @return �??串�?�????????认�?�?��
     */
    public static String defaultIfBlank(String str, String defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ?�空?��????�??�??????��? */
	/*                                                                              */
	/* 以�??��??��??��?�?���?���??空�????�??�?? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ?��?�??串头尾�???��?��?�??�??串�?<code>null</code>�???��???code>null</code>??
     * <p/>
     * <p>
     * 注�?�??<code>String.trim</code>�??�???��?使�?
     * <code>Character.isWhitespace</code>?��?�?��?��?
     * ?????��?��??��?�?????�???��?空�?�??�??空�???
     * <p/>
     * <pre>
     * StringUtil.trim(null)          = null
     * StringUtil.trim("")            = ""
     * StringUtil.trim("     ")       = ""
     * StringUtil.trim("abc")         = "abc"
     * StringUtil.trim("    abc    ") = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return ?��?空�????�?���?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String trim(String str) {
        return trim(str, null, 0);
    }

    /**
     * ?��?�??串头尾�????�??�??�??�??串�?<code>null</code>
     * �???��???code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.trim(null, *)          = null
     * StringUtil.trim("", *)            = ""
     * StringUtil.trim("abc", null)      = "abc"
     * StringUtil.trim("  abc", null)    = "abc"
     * StringUtil.trim("abc  ", null)    = "abc"
     * StringUtil.trim(" abc ", null)    = "abc"
     * StringUtil.trim("  abcyx", "xyz") = "  abc"
     * </pre>
     *
     * @param str        �?????�??�?
     * @param stripChars �???��?�??�????��<code>null</code>表示?��?空�?�??
     * @return ?��????�????????�?���?????�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String trim(String str, String stripChars) {
        return trim(str, stripChars, 0);
    }

    /**
     * ?��?�??串头?��?空�?�?????�?��??code>null</code>�??�??<code>null</code>??
     * <p/>
     * <p>
     * 注�?�??<code>String.trim</code>�??�???��?使�?
     * <code>Character.isWhitespace</code>?��?�?��?��?
     * ?????��?��??��?�?????�???��?空�?�??�??空�???
     * <p/>
     * <pre>
     * StringUtil.trimStart(null)         = null
     * StringUtil.trimStart("")           = ""
     * StringUtil.trimStart("abc")        = "abc"
     * StringUtil.trimStart("  abc")      = "abc"
     * StringUtil.trimStart("abc  ")      = "abc  "
     * StringUtil.trimStart(" abc ")      = "abc "
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return ?��?空�????�?���?????�?���?code>null</code>??????�?���?code>""</code
     * >�? ?�?? <code>null</code>
     */
    public static String trimStart(String str) {
        return trim(str, null, -1);
    }

    /**
     * ?��?�??串头?��????�??�?????�?��??code>null</code>�???��???code>null</code>?
     * ?
     * <p/>
     * <pre>
     * StringUtil.trimStart(null, *)          = null
     * StringUtil.trimStart("", *)            = ""
     * StringUtil.trimStart("abc", "")        = "abc"
     * StringUtil.trimStart("abc", null)      = "abc"
     * StringUtil.trimStart("  abc", null)    = "abc"
     * StringUtil.trimStart("abc  ", null)    = "abc  "
     * StringUtil.trimStart(" abc ", null)    = "abc "
     * StringUtil.trimStart("yxabc  ", "xyz") = "abc  "
     * </pre>
     *
     * @param str        �?????�??�?
     * @param stripChars �???��?�??�????��<code>null</code>表示?��?空�?�??
     * @return ?��????�????????�?���?????�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String trimStart(String str, String stripChars) {
        return trim(str, stripChars, -1);
    }

    /**
     * ?��?�??串尾?��?空�?�?????�?��??code>null</code>�??�??<code>null</code>??
     * <p/>
     * <p>
     * 注�?�??<code>String.trim</code>�??�???��?使�?
     * <code>Character.isWhitespace</code>?��?�?��?��?
     * ?????��?��??��?�?????�???��?空�?�??�??空�???
     * <p/>
     * <pre>
     * StringUtil.trimEnd(null)       = null
     * StringUtil.trimEnd("")         = ""
     * StringUtil.trimEnd("abc")      = "abc"
     * StringUtil.trimEnd("  abc")    = "  abc"
     * StringUtil.trimEnd("abc  ")    = "abc"
     * StringUtil.trimEnd(" abc ")    = " abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return ?��?空�????�?���?????�?���?code>null</code>??????�?���?code>""</code
     * >�? ?�?? <code>null</code>
     */
    public static String trimEnd(String str) {
        return trim(str, null, 1);
    }

    /**
     * ?��?�??串尾?��????�??�?????�?��??code>null</code>�???��???code>null</code>?
     * ?
     * <p/>
     * <pre>
     * StringUtil.trimEnd(null, *)          = null
     * StringUtil.trimEnd("", *)            = ""
     * StringUtil.trimEnd("abc", "")        = "abc"
     * StringUtil.trimEnd("abc", null)      = "abc"
     * StringUtil.trimEnd("  abc", null)    = "  abc"
     * StringUtil.trimEnd("abc  ", null)    = "abc"
     * StringUtil.trimEnd(" abc ", null)    = " abc"
     * StringUtil.trimEnd("  abcyx", "xyz") = "  abc"
     * </pre>
     *
     * @param str        �?????�??�?
     * @param stripChars �???��?�??�????��<code>null</code>表示?��?空�?�??
     * @return ?��????�????????�?���?????�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String trimEnd(String str, String stripChars) {
        return trim(str, stripChars, 1);
    }

    /**
     * ?��?�??串头尾�???��?��?�??�??�??串�?空�?�?��<code>""</code>�??�??
     * <code>null</code>??
     * <p/>
     * <p>
     * 注�?�??<code>String.trim</code>�??�???��?使�?
     * <code>Character.isWhitespace</code>?��?�?��?��?
     * ?????��?��??��?�?????�???��?空�?�??�??空�???
     * <p/>
     * <pre>
     * StringUtil.trimToNull(null)          = null
     * StringUtil.trimToNull("")            = null
     * StringUtil.trimToNull("     ")       = null
     * StringUtil.trimToNull("abc")         = "abc"
     * StringUtil.trimToNull("    abc    ") = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return ?��?空�????�?���?????�?���?code>null</code>??????�?���?code>""</code
     * >�? ?�?? <code>null</code>
     */
    public static String trimToNull(String str) {
        return trimToNull(str, null);
    }

    /**
     * ?��?�??串头尾�???��?��?�??�??�??串�?空�?�?��<code>""</code>�??�??
     * <code>null</code>??
     * <p/>
     * <p>
     * 注�?�??<code>String.trim</code>�??�???��?使�?
     * <code>Character.isWhitespace</code>?��?�?��?��?
     * ?????��?��??��?�?????�???��?空�?�??�??空�???
     * <p/>
     * <pre>
     * StringUtil.trim(null, *)          = null
     * StringUtil.trim("", *)            = null
     * StringUtil.trim("abc", null)      = "abc"
     * StringUtil.trim("  abc", null)    = "abc"
     * StringUtil.trim("abc  ", null)    = "abc"
     * StringUtil.trim(" abc ", null)    = "abc"
     * StringUtil.trim("  abcyx", "xyz") = "  abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str        �?????�??�?
     * @param stripChars �???��?�??�????��<code>null</code>表示?��?空�?�??
     * @return ?��?空�????�?���?????�?���?code>null</code>??????�?���?code>""</code
     * >�? ?�?? <code>null</code>
     */
    public static String trimToNull(String str, String stripChars) {
        String result = trim(str, stripChars);

        if ((result == null) || (result.length() == 0)) {
            return null;
        }

        return result;
    }

    /**
     * ?��?�??串头尾�???��?��?�??�??串�?<code>null</code>�??�??空�?�?��
     * <code>""</code>??
     * <p/>
     * <p>
     * 注�?�??<code>String.trim</code>�??�???��?使�?
     * <code>Character.isWhitespace</code>?��?�?��?��?
     * ?????��?��??��?�?????�???��?空�?�??�??空�???
     * <p/>
     * <pre>
     * StringUtil.trimToEmpty(null)          = ""
     * StringUtil.trimToEmpty("")            = ""
     * StringUtil.trimToEmpty("     ")       = ""
     * StringUtil.trimToEmpty("abc")         = "abc"
     * StringUtil.trimToEmpty("    abc    ") = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return ?��?空�????�?���?????�?���?code>null</code>??????�?���?code>""</code
     * >�? ?�?? <code>null</code>
     */
    public static String trimToEmpty(String str) {
        return trimToEmpty(str, null);
    }

    /**
     * ?��?�??串头尾�???��?��?�??�??串�?<code>null</code>�??�??空�?�?��
     * <code>""</code>??
     * <p/>
     * <p>
     * 注�?�??<code>String.trim</code>�??�???��?使�?
     * <code>Character.isWhitespace</code>?��?�?��?��?
     * ?????��?��??��?�?????�???��?空�?�??�??空�???
     * <p/>
     * <pre>
     * StringUtil.trim(null, *)          = ""
     * StringUtil.trim("", *)            = ""
     * StringUtil.trim("abc", null)      = "abc"
     * StringUtil.trim("  abc", null)    = "abc"
     * StringUtil.trim("abc  ", null)    = "abc"
     * StringUtil.trim(" abc ", null)    = "abc"
     * StringUtil.trim("  abcyx", "xyz") = "  abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return ?��?空�????�?���?????�?���?code>null</code>??????�?���?code>""</code
     * >�? ?�?? <code>null</code>
     */
    public static String trimToEmpty(String str, String stripChars) {
        String result = trim(str, stripChars);

        if (result == null) {
            return EMPTY_STRING;
        }

        return result;
    }

    /**
     * ?��?�??串头尾�????�??�??�??�??串�?<code>null</code>
     * �???��???code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.trim(null, *)          = null
     * StringUtil.trim("", *)            = ""
     * StringUtil.trim("abc", null)      = "abc"
     * StringUtil.trim("  abc", null)    = "abc"
     * StringUtil.trim("abc  ", null)    = "abc"
     * StringUtil.trim(" abc ", null)    = "abc"
     * StringUtil.trim("  abcyx", "xyz") = "  abc"
     * </pre>
     *
     * @param str        �?????�??�?
     * @param stripChars �???��?�??�????��<code>null</code>表示?��?空�?�??
     * @param mode       <code>-1</code>
     *                   表示trimStart�?code>0</code>表示trim?��?�?code>1</code>表示trimEnd
     * @return ?��????�????????�?���?????�?���?code>null</code>�??�??
     * <code>null</code>
     */
    private static String trim(String str, String stripChars, int mode) {
        if (str == null) {
            return null;
        }

        int length = str.length();
        int start = 0;
        int end = length;

        // ???�??串头??
        if (mode <= 0) {
            if (stripChars == null) {
                while ((start < end)
                        && (Character.isWhitespace(str.charAt(start)))) {
                    start++;
                }
            } else if (stripChars.length() == 0) {
                return str;
            } else {
                while ((start < end)
                        && (stripChars.indexOf(str.charAt(start)) != -1)) {
                    start++;
                }
            }
        }

        // ???�??串尾??
        if (mode >= 0) {
            if (stripChars == null) {
                while ((start < end)
                        && (Character.isWhitespace(str.charAt(end - 1)))) {
                    end--;
                }
            } else if (stripChars.length() == 0) {
                return str;
            } else {
                while ((start < end)
                        && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
                    end--;
                }
            }
        }

        if ((start > 0) || (end < length)) {
            return str.substring(start, end);
        }

        return str;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �???��??? */
	/*                                                                              */
	/* 以�??��??��?�??两个�??串�??????? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??两个�??串�?大�?????????
     * <p/>
     * <pre>
     * StringUtil.equals(null, null)   = true
     * StringUtil.equals(null, "abc")  = false
     * StringUtil.equals("abc", null)  = false
     * StringUtil.equals("abc", "abc") = true
     * StringUtil.equals("abc", "ABC") = false
     * </pre>
     *
     * @param str1 �??�??�??�?
     * @param str2 �??�??�??�?
     * @return �??两个�??串�????????��?<code>null</code>�??�??<code>true</code>
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equals(str2);
    }

    public static boolean equals(Number num, String str2) {
        String str1 = num + "";
        if (num == null) {
            return str2 == null;
        }
        return str1.equals(str2);
    }

    /**
     * �??两个�??串�?大�???????�??
     * <p/>
     * <pre>
     * StringUtil.equalsIgnoreCase(null, null)   = true
     * StringUtil.equalsIgnoreCase(null, "abc")  = false
     * StringUtil.equalsIgnoreCase("abc", null)  = false
     * StringUtil.equalsIgnoreCase("abc", "abc") = true
     * StringUtil.equalsIgnoreCase("abc", "ABC") = true
     * </pre>
     *
     * @param str1 �??�??�??�?
     * @param str2 �??�??�??�?
     * @return �??两个�??串�????????��?<code>null</code>�??�??<code>true</code>
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equalsIgnoreCase(str2);
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �??串类???�???��? */
	/*                                                                              */
	/* ?��?�??串�?类�????为�?�?????�??空�?�? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ?��?�??串�???????unicode�????
     * <p/>
     * <p>
     * <code>null</code>
     * �????code>false</code>�?���??�?code>""</code>�????code>true</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.isAlpha(null)   = false
     * StringUtil.isAlpha("")     = true
     * StringUtil.isAlpha("  ")   = false
     * StringUtil.isAlpha("abc")  = true
     * StringUtil.isAlpha("ab2c") = false
     * StringUtil.isAlpha("ab-c") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�??串�?<code>null</code>并�??��?unicode�??�??�??�??
     * <code>true</code>
     */
    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * ?��?�??串�???????unicode�????��??code>' '</code>??
     * <p/>
     * <p>
     * <code>null</code>
     * �????code>false</code>�?���??�?code>""</code>�????code>true</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.isAlphaSpace(null)   = false
     * StringUtil.isAlphaSpace("")     = true
     * StringUtil.isAlphaSpace("  ")   = true
     * StringUtil.isAlphaSpace("abc")  = true
     * StringUtil.isAlphaSpace("ab c") = true
     * StringUtil.isAlphaSpace("ab2c") = false
     * StringUtil.isAlphaSpace("ab-c") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�??串�?<code>null</code>
     * 并�??��?unicode�????��?��?????????code>true</code>
     */
    public static boolean isAlphaSpace(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(str.charAt(i)) && (str.charAt(i) != ' ')) {
                return false;
            }
        }

        return true;
    }

    /**
     * ?��?�??串�???????unicode�?????�??
     * <p/>
     * <p>
     * <code>null</code>
     * �????code>false</code>�?���??�?code>""</code>�????code>true</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.isAlphanumeric(null)   = false
     * StringUtil.isAlphanumeric("")     = true
     * StringUtil.isAlphanumeric("  ")   = false
     * StringUtil.isAlphanumeric("abc")  = true
     * StringUtil.isAlphanumeric("ab c") = false
     * StringUtil.isAlphanumeric("ab2c") = true
     * StringUtil.isAlphanumeric("ab-c") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�??串�?<code>null</code>并�??��?unicode�???��?�??�??�??
     * <code>true</code>
     */
    public static boolean isAlphanumeric(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * ?��?�??串�???????unicode�???��???��??code>' '</code>??
     * <p/>
     * <p>
     * <code>null</code>
     * �????code>false</code>�?���??�?code>""</code>�????code>true</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.isAlphanumericSpace(null)   = false
     * StringUtil.isAlphanumericSpace("")     = true
     * StringUtil.isAlphanumericSpace("  ")   = true
     * StringUtil.isAlphanumericSpace("abc")  = true
     * StringUtil.isAlphanumericSpace("ab c") = true
     * StringUtil.isAlphanumericSpace("ab2c") = true
     * StringUtil.isAlphanumericSpace("ab-c") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�??串�?<code>null</code>
     * 并�??��?unicode�???��???��?��?????????code>true</code>
     */
    public static boolean isAlphanumericSpace(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))
                    && (str.charAt(i) != ' ')) {
                return false;
            }
        }

        return true;
    }

    /**
     * ?��?�??串�???????unicode?��???
     * <p/>
     * <p>
     * <code>null</code>
     * �????code>false</code>�?���??�?code>""</code>�????code>true</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.isNumeric(null)   = false
     * StringUtil.isNumeric("")     = true
     * StringUtil.isNumeric("  ")   = false
     * StringUtil.isNumeric("123")  = true
     * StringUtil.isNumeric("12 3") = false
     * StringUtil.isNumeric("ab2c") = false
     * StringUtil.isNumeric("12-3") = false
     * StringUtil.isNumeric("12.3") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�??串�?<code>null</code>并�??��?unicode?��?�??�??�??
     * <code>true</code>
     */
    public static boolean isNumeric(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * ?��?�??串�???????unicode?��???��??code>' '</code>??
     * <p/>
     * <p>
     * <code>null</code>
     * �????code>false</code>�?���??�?code>""</code>�????code>true</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.isNumericSpace(null)   = false
     * StringUtil.isNumericSpace("")     = true
     * StringUtil.isNumericSpace("  ")   = true
     * StringUtil.isNumericSpace("123")  = true
     * StringUtil.isNumericSpace("12 3") = true
     * StringUtil.isNumericSpace("ab2c") = false
     * StringUtil.isNumericSpace("12-3") = false
     * StringUtil.isNumericSpace("12.3") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�??串�?<code>null</code>
     * 并�??��?unicode?��???��?��?????????code>true</code>
     */
    public static boolean isNumericSpace(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i)) && (str.charAt(i) != ' ')) {
                return false;
            }
        }

        return true;
    }

    /**
     * ?��?�??串�???????unicode空�???
     * <p/>
     * <p>
     * <code>null</code>
     * �????code>false</code>�?���??�?code>""</code>�????code>true</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.isWhitespace(null)   = false
     * StringUtil.isWhitespace("")     = true
     * StringUtil.isWhitespace("  ")   = true
     * StringUtil.isWhitespace("abc")  = false
     * StringUtil.isWhitespace("ab2c") = false
     * StringUtil.isWhitespace("ab-c") = false
     * </pre>
     *
     * @param str �???��?�??�?
     * @return �??�??串�?<code>null</code>并�??��?unicode空�?�??�??�??
     * <code>true</code>
     */
    public static boolean isWhitespace(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 大�???��??? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??�?���????��???
     * <p/>
     * <p>
     * �??�??串�?<code>null</code>?????code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.toUpperCase(null)  = null
     * StringUtil.toUpperCase("")    = ""
     * StringUtil.toUpperCase("aBc") = "ABC"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?��?��?�??�?
     * @return 大�?�??串�?�?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toUpperCase();
    }

    /**
     * �??�?���????????
     * <p/>
     * <p>
     * �??�??串�?<code>null</code>?????code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.toLowerCase(null)  = null
     * StringUtil.toLowerCase("")    = ""
     * StringUtil.toLowerCase("aBc") = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?��?��?�??�?
     * @return 大�?�??串�?�?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toLowerCase();
    }

    /**
     * �??�?��???�??�??大�?�?code>Character.toTitleCase</code>�???��?�??�????
     * <p/>
     * <p>
     * �??�??串�?<code>null</code>?????code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.capitalize(null)  = null
     * StringUtil.capitalize("")    = ""
     * StringUtil.capitalize("cat") = "Cat"
     * StringUtil.capitalize("cAt") = "CAt"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?��?��?�??�?
     * @return �??�?��大�????�?���?????�??串为<code>null</code>�??�??
     * <code>null</code>
     */
    public static String capitalize(String str) {
        int strLen;

        if ((str == null) || ((strLen = str.length()) == 0)) {
            return str;
        }

        return new StringBuffer(strLen)
                .append(Character.toTitleCase(str.charAt(0)))
                .append(str.substring(1)).toString();
    }

    /**
     * �??�?��???�??�??�??�??�??�?????
     * <p/>
     * <p>
     * �??�??串�?<code>null</code>?????code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.uncapitalize(null)  = null
     * StringUtil.uncapitalize("")    = ""
     * StringUtil.uncapitalize("Cat") = "cat"
     * StringUtil.uncapitalize("CAT") = "cAT"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?��?��?�??�?
     * @return �??�?���?????�?���?????�??串为<code>null</code>�??�??
     * <code>null</code>
     */
    public static String uncapitalize(String str) {
        int strLen;

        if ((str == null) || ((strLen = str.length()) == 0)) {
            return str;
        }

        return new StringBuffer(strLen)
                .append(Character.toLowerCase(str.charAt(0)))
                .append(str.substring(1)).toString();
    }

    /**
     * ??���??串�?大�????
     * <p/>
     * <p>
     * �??�??串�?<code>null</code>?????code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.swapCase(null)                 = null
     * StringUtil.swapCase("")                   = ""
     * StringUtil.swapCase("The dog has a BONE") = "tHE DOG HAS A bone"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?��?��?�??�?
     * @return 大�??????��???�?���?????�??串为<code>null</code>�??�??
     * <code>null</code>
     */
    public static String swapCase(String str) {
        int strLen;

        if ((str == null) || ((strLen = str.length()) == 0)) {
            return str;
        }

        StringBuffer buffer = new StringBuffer(strLen);

        char ch = 0;

        for (int i = 0; i < strLen; i++) {
            ch = str.charAt(i);

            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }

            buffer.append(ch);
        }

        return buffer.toString();
    }

    protected boolean isDelimiter(char ch) {
        return !Character.isUpperCase(ch) && !Character.isLowerCase(ch)
                && !Character.isDigit(ch);
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �??串�??��??��? */
	/*                                                                              */
	/* �??�??象�???????�???��?�??串�? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??�?��???�???��?�?���??串�?
     * <p/>
     * <pre>
     * StringUtil.join(null)            = null
     * StringUtil.join([])              = ""
     * StringUtil.join([null])          = ""
     * StringUtil.join(["a", "b", "c"]) = "abc"
     * StringUtil.join([null, "", "a"]) = "a"
     * </pre>
     *
     * @param array �???��??��?
     * @return �?????�??串�?�?????�?��<code>null</code>�??�??<code>null</code>
     */
    public static String join(Object[] array) {
        return join(array, null);
    }

    /**
     * �??�?��???�???��?�?���??串�?
     * <p/>
     * <pre>
     * StringUtil.join(null, *)               = null
     * StringUtil.join([], *)                 = ""
     * StringUtil.join([null], *)             = ""
     * StringUtil.join(["a", "b", "c"], ';')  = "a;b;c"
     * StringUtil.join(["a", "b", "c"], null) = "abc"
     * StringUtil.join([null, "", "a"], ';')  = ";;a"
     * </pre>
     *
     * @param array     �???��??��?
     * @param separator ???�?
     * @return �?????�??串�?�?????�?��<code>null</code>�??�??<code>null</code>
     */
    public static String join(Object[] array, char separator) {
        if (array == null) {
            return null;
        }

        int arraySize = array.length;
        int bufSize = (arraySize == 0) ? 0 : ((((array[0] == null) ? 16
                : array[0].toString().length()) + 1) * arraySize);
        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = 0; i < arraySize; i++) {
            if (i > 0) {
                buf.append(separator);
            }

            if (array[i] != null) {
                buf.append(array[i]);
            }
        }

        return buf.toString();
    }

    /**
     * �??�?��???�???��?�?���??串�?
     * <p/>
     * <pre>
     * StringUtil.join(null, *)                = null
     * StringUtil.join([], *)                  = ""
     * StringUtil.join([null], *)              = ""
     * StringUtil.join(["a", "b", "c"], "--")  = "a--b--c"
     * StringUtil.join(["a", "b", "c"], null)  = "abc"
     * StringUtil.join(["a", "b", "c"], "")    = "abc"
     * StringUtil.join([null, "", "a"], ',')   = ",,a"
     * </pre>
     *
     * @param array     �???��??��?
     * @param separator ???�?
     * @return �?????�??串�?�?????�?��<code>null</code>�??�??<code>null</code>
     */
    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }

        if (separator == null) {
            separator = EMPTY_STRING;
        }

        int arraySize = array.length;

        // ArraySize == 0: Len = 0
        // ArraySize > 0: Len = NofStrings *(len(firstString) + len(separator))
        // (估�?大约??????�?��?��??��?)
        int bufSize = (arraySize == 0) ? 0
                : (arraySize * (((array[0] == null) ? 16 : array[0].toString()
                .length()) + ((separator != null) ? separator.length()
                : 0)));

        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = 0; i < arraySize; i++) {
            if ((separator != null) && (i > 0)) {
                buf.append(separator);
            }

            if (array[i] != null) {
                buf.append(array[i]);
            }
        }

        return buf.toString();
    }

    /**
     * �?code>Iterator</code>�?????�?????�??�?��??
     * <p/>
     * <pre>
     * StringUtil.join(null, *)                = null
     * StringUtil.join([], *)                  = ""
     * StringUtil.join([null], *)              = ""
     * StringUtil.join(["a", "b", "c"], "--")  = "a--b--c"
     * StringUtil.join(["a", "b", "c"], null)  = "abc"
     * StringUtil.join(["a", "b", "c"], "")    = "abc"
     * StringUtil.join([null, "", "a"], ',')   = ",,a"
     * </pre>
     *
     * @param iterator  �???��?<code>Iterator</code>
     * @param separator ???�?
     * @return �?????�??串�?�?????�?��<code>null</code>�??�??<code>null</code>
     */
    public static String join(Iterator<?> iterator, char separator) {
        if (iterator == null) {
            return null;
        }

        StringBuffer buf = new StringBuffer(256); // Java�???��?16, ??????

        while (iterator.hasNext()) {
            Object obj = iterator.next();

            if (obj != null) {
                buf.append(obj);
            }

            if (iterator.hasNext()) {
                buf.append(separator);
            }
        }

        return buf.toString();
    }

    /**
     * �?code>Iterator</code>�?????�?????�??�?��??
     * <p/>
     * <pre>
     * StringUtil.join(null, *)                = null
     * StringUtil.join([], *)                  = ""
     * StringUtil.join([null], *)              = ""
     * StringUtil.join(["a", "b", "c"], "--")  = "a--b--c"
     * StringUtil.join(["a", "b", "c"], null)  = "abc"
     * StringUtil.join(["a", "b", "c"], "")    = "abc"
     * StringUtil.join([null, "", "a"], ',')   = ",,a"
     * </pre>
     *
     * @param iterator  �???��?<code>Iterator</code>
     * @param separator ???�?
     * @return �?????�??串�?�?????�?��<code>null</code>�??�??<code>null</code>
     */
    public static String join(Iterator<?> iterator, String separator) {
        if (iterator == null) {
            return null;
        }

        StringBuffer buf = new StringBuffer(256); // Java�???��?16, ??????

        while (iterator.hasNext()) {
            Object obj = iterator.next();

            if (obj != null) {
                buf.append(obj);
            }

            if ((separator != null) && iterator.hasNext()) {
                buf.append(separator);
            }
        }

        return buf.toString();
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �??串�??��?????? �?????�?��?? */
	/*                                                                              */
	/* ?��?�?���???��?�??�??�??串�? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ?��?�?���???��?�??�??并�????�?��?��???���????????�?���?code>null</code>???
     * ?��?�??� ??<code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.indexOf(null, *)         = -1
     * StringUtil.indexOf("", *)           = -1
     * StringUtil.indexOf("aabaabaa", 'a') = 0
     * StringUtil.indexOf("aabaabaa", 'b') = 2
     * </pre>
     *
     * @param str        �?????�??�?
     * @param searchChar �???��?�??
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOf(String str, char searchChar) {
        if ((str == null) || (str.length() == 0)) {
            return -1;
        }

        return str.indexOf(searchChar);
    }

    /**
     * ?��?�?���???��?�??�??并�????�?��?��???���????????�?���?code>null</code>???
     * ?��?�??� ??<code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.indexOf(null, *, *)          = -1
     * StringUtil.indexOf("", *, *)            = -1
     * StringUtil.indexOf("aabaabaa", 'b', 0)  = 2
     * StringUtil.indexOf("aabaabaa", 'b', 3)  = 5
     * StringUtil.indexOf("aabaabaa", 'b', 9)  = -1
     * StringUtil.indexOf("aabaabaa", 'b', -1) = 2
     * </pre>
     *
     * @param str        �?????�??�?
     * @param searchChar �???��?�??
     * @param startPos   �????��??���??�?????�?�?????0
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOf(String str, char searchChar, int startPos) {
        if ((str == null) || (str.length() == 0)) {
            return -1;
        }

        return str.indexOf(searchChar, startPos);
    }

    /**
     * ?��?�?���???��?�??�?���?���??�??�?????索�??��?�??�??串为<code>null</code>
     * ????��?�??�??<code>-1</code> ??
     * <p/>
     * <pre>
     * StringUtil.indexOf(null, *)          = -1
     * StringUtil.indexOf(*, null)          = -1
     * StringUtil.indexOf("", "")           = 0
     * StringUtil.indexOf("aabaabaa", "a")  = 0
     * StringUtil.indexOf("aabaabaa", "b")  = 2
     * StringUtil.indexOf("aabaabaa", "ab") = 1
     * StringUtil.indexOf("aabaabaa", "")   = 0
     * </pre>
     *
     * @param str       �?????�??�?
     * @param searchStr �???��?�??�?
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOf(String str, String searchStr) {
        if ((str == null) || (searchStr == null)) {
            return -1;
        }

        return str.indexOf(searchStr);
    }

    /**
     * ?��?�?���???��?�??�?���?���??�??�?????索�??��?�??�??串为<code>null</code>
     * ????��?�??�??<code>-1</code> ??
     * <p/>
     * <pre>
     * StringUtil.indexOf(null, *, *)          = -1
     * StringUtil.indexOf(*, null, *)          = -1
     * StringUtil.indexOf("", "", 0)           = 0
     * StringUtil.indexOf("aabaabaa", "a", 0)  = 0
     * StringUtil.indexOf("aabaabaa", "b", 0)  = 2
     * StringUtil.indexOf("aabaabaa", "ab", 0) = 1
     * StringUtil.indexOf("aabaabaa", "b", 3)  = 5
     * StringUtil.indexOf("aabaabaa", "b", 9)  = -1
     * StringUtil.indexOf("aabaabaa", "b", -1) = 2
     * StringUtil.indexOf("aabaabaa", "", 2)   = 2
     * StringUtil.indexOf("abc", "", 9)        = 3
     * </pre>
     *
     * @param str       �?????�??�?
     * @param searchStr �???��?�??�?
     * @param startPos  �????��??���??�?????�?�?????0
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOf(String str, String searchStr, int startPos) {
        if ((str == null) || (searchStr == null)) {
            return -1;
        }

        // JDK1.3??���?????bug�???��?�??????��????
        if ((searchStr.length() == 0) && (startPos >= str.length())) {
            return str.length();
        }

        return str.indexOf(searchStr, startPos);
    }

    /**
     * ?��?�?���???��?�??�????��???�??并�????�?��?��???���?���?? �??�??串为
     * <code>null</code>�??�?? <code>-1</code>??
     * �??�?????�?code>null</code>??���??�??<code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.indexOfAny(null, *)                = -1
     * StringUtil.indexOfAny("", *)                  = -1
     * StringUtil.indexOfAny(*, null)                = -1
     * StringUtil.indexOfAny(*, [])                  = -1
     * StringUtil.indexOfAny("zzabyycdxx",['z','a']) = 0
     * StringUtil.indexOfAny("zzabyycdxx",['b','y']) = 3
     * StringUtil.indexOfAny("aba", ['z'])           = -1
     * </pre>
     *
     * @param str         �?????�??�?
     * @param searchChars �??索�?�?????
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOfAny(String str, char[] searchChars) {
        if ((str == null) || (str.length() == 0) || (searchChars == null)
                || (searchChars.length == 0)) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            for (int j = 0; j < searchChars.length; j++) {
                if (searchChars[j] == ch) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * ?��?�?���???��?�??�????��???�??并�????�?��?��???���?���?? �??�??串为
     * <code>null</code>�??�?? <code>-1</code>??
     * �??�?????�?code>null</code>??���??�??<code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.indexOfAny(null, *)            = -1
     * StringUtil.indexOfAny("", *)              = -1
     * StringUtil.indexOfAny(*, null)            = -1
     * StringUtil.indexOfAny(*, "")              = -1
     * StringUtil.indexOfAny("zzabyycdxx", "za") = 0
     * StringUtil.indexOfAny("zzabyycdxx", "by") = 3
     * StringUtil.indexOfAny("aba","z")          = -1
     * </pre>
     *
     * @param str         �?????�??�?
     * @param searchChars �??索�?�?????
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOfAny(String str, String searchChars) {
        if ((str == null) || (str.length() == 0) || (searchChars == null)
                || (searchChars.length() == 0)) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            for (int j = 0; j < searchChars.length(); j++) {
                if (searchChars.charAt(j) == ch) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * ?��?�?���???��?�??�?��???�??�??串�?并�????�?��?��???���?���?? �??�??串为
     * <code>null</code>�??�?? <code>-1</code>?? �??�??串�???��<code>null</code>
     * ??���??�??<code>-1</code>?? �??�??串�??????code>""</code>�?���??�?���?��
     * <code>null</code>�??�??<code>str.length()</code>
     * <p/>
     * <pre>
     * StringUtil.indexOfAny(null, *)                     = -1
     * StringUtil.indexOfAny(*, null)                     = -1
     * StringUtil.indexOfAny(*, [])                       = -1
     * StringUtil.indexOfAny("zzabyycdxx", ["ab","cd"])   = 2
     * StringUtil.indexOfAny("zzabyycdxx", ["cd","ab"])   = 2
     * StringUtil.indexOfAny("zzabyycdxx", ["mn","op"])   = -1
     * StringUtil.indexOfAny("zzabyycdxx", ["zab","aby"]) = 1
     * StringUtil.indexOfAny("zzabyycdxx", [""])          = 0
     * StringUtil.indexOfAny("", [""])                    = 0
     * StringUtil.indexOfAny("", ["a"])                   = -1
     * </pre>
     *
     * @param str        �?????�??�?
     * @param searchStrs �??索�?�??串�???
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOfAny(String str, String[] searchStrs) {
        if ((str == null) || (searchStrs == null)) {
            return -1;
        }

        int sz = searchStrs.length;

        // String's can't have a MAX_VALUEth index.
        int ret = Integer.MAX_VALUE;

        int tmp = 0;

        for (int i = 0; i < sz; i++) {
            String search = searchStrs[i];

            if (search == null) {
                continue;
            }

            tmp = str.indexOf(search);

            if (tmp == -1) {
                continue;
            }

            if (tmp < ret) {
                ret = tmp;
            }
        }

        return (ret == Integer.MAX_VALUE) ? (-1) : ret;
    }

    /**
     * ?��?�?���???��??��?�??�????��???�??并�????�?��?��???���?���?? �??�??串为
     * <code>null</code>�??�?? <code>-1</code>??
     * �??�?????�?code>null</code>??���??�??<code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.indexOfAnyBut(null, *)             = -1
     * StringUtil.indexOfAnyBut("", *)               = -1
     * StringUtil.indexOfAnyBut(*, null)             = -1
     * StringUtil.indexOfAnyBut(*, [])               = -1
     * StringUtil.indexOfAnyBut("zzabyycdxx",'za')   = 3
     * StringUtil.indexOfAnyBut("zzabyycdxx", 'by')  = 0
     * StringUtil.indexOfAnyBut("aba", 'ab')         = -1
     * </pre>
     *
     * @param str         �?????�??�?
     * @param searchChars �??索�?�?????
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOfAnyBut(String str, char[] searchChars) {
        if ((str == null) || (str.length() == 0) || (searchChars == null)
                || (searchChars.length == 0)) {
            return -1;
        }

        outer:
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            for (int j = 0; j < searchChars.length; j++) {
                if (searchChars[j] == ch) {
                    continue outer;
                }
            }

            return i;
        }

        return -1;
    }

    /**
     * ?��?�?���???��??��?�??�????��???�??并�????�?��?��???���?���?? �??�??串为
     * <code>null</code>�??�?? <code>-1</code>??
     * �??�?????�?code>null</code>??���??�??<code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.indexOfAnyBut(null, *)            = -1
     * StringUtil.indexOfAnyBut("", *)              = -1
     * StringUtil.indexOfAnyBut(*, null)            = -1
     * StringUtil.indexOfAnyBut(*, "")              = -1
     * StringUtil.indexOfAnyBut("zzabyycdxx", "za") = 3
     * StringUtil.indexOfAnyBut("zzabyycdxx", "by") = 0
     * StringUtil.indexOfAnyBut("aba","ab")         = -1
     * </pre>
     *
     * @param str         �?????�??�?
     * @param searchChars �??索�?�?????
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int indexOfAnyBut(String str, String searchChars) {
        if ((str == null) || (str.length() == 0) || (searchChars == null)
                || (searchChars.length() == 0)) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (searchChars.indexOf(str.charAt(i)) < 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * ?��?�??串中�??�?���??�???????ndex
     *
     * @param str �?????�??�?
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     * @author wuhaoxiang
     */
    public static int indexOfFirstChinese(String str) {
        String matchChinese = "[\u4e00-\u9fa5]";

        if ((str == null) || (str.length() == 0)) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (temp.matches(matchChinese)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * ?��?�??串中�??�?���??�??�?????�?��?? �??类�?????��????�???��?�??�??�??�????
     *
     * @param str �?????�??�?
     * @return �??�??串中??��????????���?
     * @author wuhaoxiang
     */
    public static String getFirstChineseSubstring(String str) {
        int idx = indexOfFirstChinese(str);

        if (idx == -1) {
            return "";
        } else {
            return str.substring(idx);
        }
    }

    /**
     * �??�?��尾�?�???��????�??�?���??�??�?????索�??��?�??�??串为<code>null</code>
     * ????��?�??�?? <code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.lastIndexOf(null, *)         = -1
     * StringUtil.lastIndexOf("", *)           = -1
     * StringUtil.lastIndexOf("aabaabaa", 'a') = 7
     * StringUtil.lastIndexOf("aabaabaa", 'b') = 5
     * </pre>
     *
     * @param str        �?????�??�?
     * @param searchChar �???��?�??
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int lastIndexOf(String str, char searchChar) {
        if ((str == null) || (str.length() == 0)) {
            return -1;
        }

        return str.lastIndexOf(searchChar);
    }

    /**
     * �??�?��尾�?�???��????�??�?���??�??�?????索�??��?�??�??串为<code>null</code>
     * ????��?�??�?? <code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.lastIndexOf(null, *, *)          = -1
     * StringUtil.lastIndexOf("", *,  *)           = -1
     * StringUtil.lastIndexOf("aabaabaa", 'b', 8)  = 5
     * StringUtil.lastIndexOf("aabaabaa", 'b', 4)  = 2
     * StringUtil.lastIndexOf("aabaabaa", 'b', 0)  = -1
     * StringUtil.lastIndexOf("aabaabaa", 'b', 9)  = 5
     * StringUtil.lastIndexOf("aabaabaa", 'b', -1) = -1
     * StringUtil.lastIndexOf("aabaabaa", 'a', 0)  = 0
     * </pre>
     *
     * @param str        �?????�??�?
     * @param searchChar �???��?�??
     * @param startPos   �??�?���??�?????�?
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int lastIndexOf(String str, char searchChar, int startPos) {
        if ((str == null) || (str.length() == 0)) {
            return -1;
        }

        return str.lastIndexOf(searchChar, startPos);
    }

    /**
     * �??�?��尾�?�???��????�??串�?并�????�?��?��???���????????�?���?code>null</
     * code>???? ��?�??�?? <code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.lastIndexOf(null, *)         = -1
     * StringUtil.lastIndexOf("", *)           = -1
     * StringUtil.lastIndexOf("aabaabaa", 'a') = 7
     * StringUtil.lastIndexOf("aabaabaa", 'b') = 5
     * </pre>
     *
     * @param str       �?????�??�?
     * @param searchStr �???��?�??�?
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int lastIndexOf(String str, String searchStr) {
        if ((str == null) || (searchStr == null)) {
            return -1;
        }

        return str.lastIndexOf(searchStr);
    }

    /**
     * �??�?��尾�?�???��????�??串�?并�????�?��?��???���????????�?���?code>null</
     * code>???? ��?�??�?? <code>-1</code>??
     * <p/>
     * <pre>
     * StringUtil.lastIndexOf(null, *, *)          = -1
     * StringUtil.lastIndexOf(*, null, *)          = -1
     * StringUtil.lastIndexOf("aabaabaa", "a", 8)  = 7
     * StringUtil.lastIndexOf("aabaabaa", "b", 8)  = 5
     * StringUtil.lastIndexOf("aabaabaa", "ab", 8) = 4
     * StringUtil.lastIndexOf("aabaabaa", "b", 9)  = 5
     * StringUtil.lastIndexOf("aabaabaa", "b", -1) = -1
     * StringUtil.lastIndexOf("aabaabaa", "a", 0)  = 0
     * StringUtil.lastIndexOf("aabaabaa", "b", 0)  = -1
     * </pre>
     *
     * @param str       �?????�??�?
     * @param searchStr �???��?�??�?
     * @param startPos  �??�?���??�?????�?
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int lastIndexOf(String str, String searchStr, int startPos) {
        if ((str == null) || (searchStr == null)) {
            return -1;
        }

        return str.lastIndexOf(searchStr, startPos);
    }

    /**
     * �??�?��尾�?�???��????�??串�???��???�?���?���??�??�?????起�?索�???�??�??串为
     * <code>null</code>�??�?? <code>-1</code>?? �??�??串�???��<code>null</code>
     * ??���??�??<code>-1</code>?? �??�??串�??????code>""</code>�?���??�?���?��
     * <code>null</code>�??�??<code>str.length()</code>
     * <p/>
     * <pre>
     * StringUtil.lastIndexOfAny(null, *)                   = -1
     * StringUtil.lastIndexOfAny(*, null)                   = -1
     * StringUtil.lastIndexOfAny(*, [])                     = -1
     * StringUtil.lastIndexOfAny(*, [null])                 = -1
     * StringUtil.lastIndexOfAny("zzabyycdxx", ["ab","cd"]) = 6
     * StringUtil.lastIndexOfAny("zzabyycdxx", ["cd","ab"]) = 6
     * StringUtil.lastIndexOfAny("zzabyycdxx", ["mn","op"]) = -1
     * StringUtil.lastIndexOfAny("zzabyycdxx", ["mn","op"]) = -1
     * StringUtil.lastIndexOfAny("zzabyycdxx", ["mn",""])   = 10
     * </pre>
     *
     * @param str        �?????�??�?
     * @param searchStrs �??索�?�??串�???
     * @return �??�?????索�??��?�??�??串为<code>null</code>????��?�??�??
     * <code>-1</code>
     */
    public static int lastIndexOfAny(String str, String[] searchStrs) {
        if ((str == null) || (searchStrs == null)) {
            return -1;
        }

        int searchStrsLength = searchStrs.length;
        int index = -1;
        int tmp = 0;

        for (int i = 0; i < searchStrsLength; i++) {
            String search = searchStrs[i];

            if (search == null) {
                continue;
            }

            tmp = str.lastIndexOf(search);

            if (tmp > index) {
                index = tmp;
            }
        }

        return index;
    }

    /**
     * �??�??串中????????????�??�??�??串为<code>null</code>�??�?? <code>false</code>
     * ??
     * <p/>
     * <pre>
     * StringUtil.contains(null, *)    = false
     * StringUtil.contains("", *)      = false
     * StringUtil.contains("abc", 'a') = true
     * StringUtil.contains("abc", 'z') = false
     * </pre>
     *
     * @param str        �?????�??�?
     * @param searchChar �???��?�??
     * @return �???��?�??�??<code>true</code>
     */
    public static boolean contains(String str, char searchChar) {
        if ((str == null) || (str.length() == 0)) {
            return false;
        }

        return str.indexOf(searchChar) >= 0;
    }

    /**
     * �??�??串中????????????�?��??????�?���?code>null</code>�??�??
     * <code>false</code>??
     * <p/>
     * <pre>
     * StringUtil.contains(null, *)     = false
     * StringUtil.contains(*, null)     = false
     * StringUtil.contains("", "")      = true
     * StringUtil.contains("abc", "")   = true
     * StringUtil.contains("abc", "a")  = true
     * StringUtil.contains("abc", "z")  = false
     * </pre>
     *
     * @param str       �?????�??�?
     * @param searchStr �???��?�??�?
     * @return �???��?�??�??<code>true</code>
     */
    public static boolean contains(String str, String searchStr) {
        if ((str == null) || (searchStr == null)) {
            return false;
        }

        return str.indexOf(searchStr) >= 0;
    }

    /**
     * �??�??串�??????????�??�????��???�??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>false</code>??
     * �??�?????�?code>null</code>?????code>false</code>??�??空�?�?��永�?�??
     * <code>true</code>.
     * </p>
     * <p/>
     * <pre>
     * StringUtil.containsOnly(null, *)       = false
     * StringUtil.containsOnly(*, null)       = false
     * StringUtil.containsOnly("", *)         = true
     * StringUtil.containsOnly("ab", '')      = false
     * StringUtil.containsOnly("abab", 'abc') = true
     * StringUtil.containsOnly("ab1", 'abc')  = false
     * StringUtil.containsOnly("abz", 'abc')  = false
     * </pre>
     *
     * @param str   �?????�??�?
     * @param valid �???��?�??�?
     * @return �???��?�??�??<code>true</code>
     */
    public static boolean containsOnly(String str, char[] valid) {
        if ((valid == null) || (str == null)) {
            return false;
        }

        if (str.length() == 0) {
            return true;
        }

        if (valid.length == 0) {
            return false;
        }

        return indexOfAnyBut(str, valid) == -1;
    }

    /**
     * �??�??串�??????????�??�????��???�??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>false</code>??
     * �??�?????�?code>null</code>?????code>false</code>??�??空�?�?��永�?�??
     * <code>true</code>.
     * </p>
     * <p/>
     * <pre>
     * StringUtil.containsOnly(null, *)       = false
     * StringUtil.containsOnly(*, null)       = false
     * StringUtil.containsOnly("", *)         = true
     * StringUtil.containsOnly("ab", "")      = false
     * StringUtil.containsOnly("abab", "abc") = true
     * StringUtil.containsOnly("ab1", "abc")  = false
     * StringUtil.containsOnly("abz", "abc")  = false
     * </pre>
     *
     * @param str   �?????�??�?
     * @param valid �???��?�??�?
     * @return �???��?�??�??<code>true</code>
     */
    public static boolean containsOnly(String str, String valid) {
        if ((str == null) || (valid == null)) {
            return false;
        }

        return containsOnly(str, valid.toCharArray());
    }

    /**
     * �??�??串�????�?????�??�????��???�??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>false</code>
     * ??�??�?????�?code>null</code>?????code>true</code>?? �??空�?�?��永�?�??
     * <code>true</code>.
     * </p>
     * <p/>
     * <pre>
     * StringUtil.containsNone(null, *)       = true
     * StringUtil.containsNone(*, null)       = true
     * StringUtil.containsNone("", *)         = true
     * StringUtil.containsNone("ab", '')      = true
     * StringUtil.containsNone("abab", 'xyz') = true
     * StringUtil.containsNone("ab1", 'xyz')  = true
     * StringUtil.containsNone("abz", 'xyz')  = false
     * </pre>
     *
     * @param str     �?????�??�?
     * @param invalid �???��?�??�?
     * @return �???��?�??�??<code>true</code>
     */
    public static boolean containsNone(String str, char[] invalid) {
        if ((str == null) || (invalid == null)) {
            return true;
        }

        int strSize = str.length();
        int validSize = invalid.length;

        for (int i = 0; i < strSize; i++) {
            char ch = str.charAt(i);

            for (int j = 0; j < validSize; j++) {
                if (invalid[j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * �??�??串�????�?????�??�????��???�??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>false</code>
     * ??�??�?????�?code>null</code>?????code>true</code>?? �??空�?�?��永�?�??
     * <code>true</code>.
     * </p>
     * <p/>
     * <pre>
     * StringUtil.containsNone(null, *)       = true
     * StringUtil.containsNone(*, null)       = true
     * StringUtil.containsNone("", *)         = true
     * StringUtil.containsNone("ab", "")      = true
     * StringUtil.containsNone("abab", "xyz") = true
     * StringUtil.containsNone("ab1", "xyz")  = true
     * StringUtil.containsNone("abz", "xyz")  = false
     * </pre>
     *
     * @param str          �?????�??�?
     * @param invalidChars �???��?�??�?
     * @return �???��?�??�??<code>true</code>
     */
    public static boolean containsNone(String str, String invalidChars) {
        if ((str == null) || (invalidChars == null)) {
            return true;
        }

        return containsNone(str, invalidChars.toCharArray());
    }

    /**
     * ??????�?��?��?�?���???��?次�???
     * <p/>
     * <p>
     * �??�??串为<code>null</code>??���??�??<code>0</code>??
     * <p/>
     * <pre>
     * StringUtil.countMatches(null, *)       = 0
     * StringUtil.countMatches("", *)         = 0
     * StringUtil.countMatches("abba", null)  = 0
     * StringUtil.countMatches("abba", "")    = 0
     * StringUtil.countMatches("abba", "a")   = 2
     * StringUtil.countMatches("abba", "ab")  = 1
     * StringUtil.countMatches("abba", "xxx") = 0
     * </pre>
     * <p/>
     * </p>
     *
     * @param str    �?????�??�?
     * @param subStr �??�?��
     * @return �?��?��?�?���???��?次�?�?????�?���?code>null</code>??���??�??
     * <code>0</code>
     */
    public static int countMatches(String str, String subStr) {
        if ((str == null) || (str.length() == 0) || (subStr == null)
                || (subStr.length() == 0)) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }

        return count;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ???串�??��? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ???�??�?��???串�?
     * <p/>
     * <p>
     * �??索�?代表�?��?��?�??�??�??�??串为<code>null</code>�??�??<code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.substring(null, *)   = null
     * StringUtil.substring("", *)     = ""
     * StringUtil.substring("abc", 0)  = "abc"
     * StringUtil.substring("abc", 2)  = "c"
     * StringUtil.substring("abc", 4)  = ""
     * StringUtil.substring("abc", -2) = "bc"
     * StringUtil.substring("abc", -4) = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str   �??�?
     * @param start 起�?索�?�????���??�?��示�?尾�??��?
     * @return �?���?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String substring(String str, int start) {
        if (str == null) {
            return null;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }

        if (start > str.length()) {
            return EMPTY_STRING;
        }

        return str.substring(start);
    }

    /**
     * ???�??�?��???串�?
     * <p/>
     * <p>
     * �??索�?代表�?��?��?�??�??�??�??串为<code>null</code>�??�??<code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.substring(null, *, *)    = null
     * StringUtil.substring("", * ,  *)    = "";
     * StringUtil.substring("abc", 0, 2)   = "ab"
     * StringUtil.substring("abc", 2, 0)   = ""
     * StringUtil.substring("abc", 2, 4)   = "c"
     * StringUtil.substring("abc", 4, 6)   = ""
     * StringUtil.substring("abc", 2, 2)   = ""
     * StringUtil.substring("abc", -2, -1) = "b"
     * StringUtil.substring("abc", -4, 2)  = "ab"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str   �??�?
     * @param start 起�?索�?�????���??�?��示�?尾�?计�?
     * @param end   �??索�?�?????�????���??�?��示�?尾�?计�?
     * @return �?���?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }

        if (end < 0) {
            end = str.length() + end;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return EMPTY_STRING;
        }

        if (start < 0) {
            start = 0;
        }

        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * ????�度为�?�??�?????�?��???串�?
     * <p/>
     * <pre>
     * StringUtil.left(null, *)    = null
     * StringUtil.left(*, -ve)     = ""
     * StringUtil.left("", *)      = ""
     * StringUtil.left("abc", 0)   = ""
     * StringUtil.left("abc", 2)   = "ab"
     * StringUtil.left("abc", 4)   = "abc"
     * </pre>
     *
     * @param str �??�?
     * @param len ??���?��???�?
     * @return �?���?????�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String left(String str, int len) {
        if (str == null) {
            return null;
        }

        if (len < 0) {
            return EMPTY_STRING;
        }

        if (str.length() <= len) {
            return str;
        } else {
            return str.substring(0, len);
        }
    }

    /**
     * ????�度为�?�??�??????�边???串�?
     * <p/>
     * <pre>
     * StringUtil.right(null, *)    = null
     * StringUtil.right(*, -ve)     = ""
     * StringUtil.right("", *)      = ""
     * StringUtil.right("abc", 0)   = ""
     * StringUtil.right("abc", 2)   = "bc"
     * StringUtil.right("abc", 4)   = "abc"
     * </pre>
     *
     * @param str �??�?
     * @param len ???�?��???�?
     * @return �?���?????�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }

        if (len < 0) {
            return EMPTY_STRING;
        }

        if (str.length() <= len) {
            return str;
        } else {
            return str.substring(str.length() - len);
        }
    }

    /**
     * ???�??�?���??�??�?????�?��???�???��?�?��??
     * <p/>
     * <pre>
     * StringUtil.mid(null, *, *)    = null
     * StringUtil.mid(*, *, -ve)     = ""
     * StringUtil.mid("", 0, *)      = ""
     * StringUtil.mid("abc", 0, 2)   = "ab"
     * StringUtil.mid("abc", 0, 4)   = "abc"
     * StringUtil.mid("abc", 2, 4)   = "c"
     * StringUtil.mid("abc", 4, 2)   = ""
     * StringUtil.mid("abc", -2, 2)  = "ab"
     * </pre>
     *
     * @param str �??�?
     * @param pos 起�?索�?�????���??�?????<code>0</code>
     * @param len �?��???�??�??为�??��????�??�?��<code>0</code>
     * @return �?���?????�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String mid(String str, int pos, int len) {
        if (str == null) {
            return null;
        }

        if ((len < 0) || (pos > str.length())) {
            return EMPTY_STRING;
        }

        if (pos < 0) {
            pos = 0;
        }

        if (str.length() <= (pos + len)) {
            return str.substring(pos);
        } else {
            return str.substring(pos, pos + len);
        }
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ??��并�?�?��?��??? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ???�??�???��????�?���?????串�?
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�?????�?���?code>null</code>????��?该�?串�???????�??串�?
     * <p/>
     * <pre>
     * StringUtil.substringBefore(null, *)      = null
     * StringUtil.substringBefore("", *)        = ""
     * StringUtil.substringBefore("abc", "a")   = ""
     * StringUtil.substringBefore("abcba", "b") = "a"
     * StringUtil.substringBefore("abc", "c")   = "ab"
     * StringUtil.substringBefore("abc", "d")   = "abc"
     * StringUtil.substringBefore("abc", "")    = ""
     * StringUtil.substringBefore("abc", null)  = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str       �??�?
     * @param separator �??索�????�?��
     * @return �?���?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String substringBefore(String str, String separator) {
        if ((str == null) || (separator == null) || (str.length() == 0)) {
            return str;
        }

        if (separator.length() == 0) {
            return EMPTY_STRING;
        }

        int pos = str.indexOf(separator);

        if (pos == -1) {
            return str;
        }

        return str.substring(0, pos);
    }

    /**
     * ???�??�???��????�?���?????串�?
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�?????�?���?code>null</code>????��?该�?串�???????�??串�?
     * <p/>
     * <pre>
     * StringUtil.substringAfter(null, *)      = null
     * StringUtil.substringAfter("", *)        = ""
     * StringUtil.substringAfter(*, null)      = ""
     * StringUtil.substringAfter("abc", "a")   = "bc"
     * StringUtil.substringAfter("abcba", "b") = "cba"
     * StringUtil.substringAfter("abc", "c")   = ""
     * StringUtil.substringAfter("abc", "d")   = ""
     * StringUtil.substringAfter("abc", "")    = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str       �??�?
     * @param separator �??索�????�?��
     * @return �?���?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String substringAfter(String str, String separator) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }

        if (separator == null) {
            return EMPTY_STRING;
        }

        int pos = str.indexOf(separator);

        if (pos == -1) {
            return EMPTY_STRING;
        }

        return str.substring(pos + separator.length());
    }

    /**
     * ??????�?��??????串�????�?��??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�?????�?���?code>null</code>????��?该�?串�???????�??串�?
     * <p/>
     * <pre>
     * StringUtil.substringBeforeLast(null, *)      = null
     * StringUtil.substringBeforeLast("", *)        = ""
     * StringUtil.substringBeforeLast("abcba", "b") = "abc"
     * StringUtil.substringBeforeLast("abc", "c")   = "ab"
     * StringUtil.substringBeforeLast("a", "a")     = ""
     * StringUtil.substringBeforeLast("a", "z")     = "a"
     * StringUtil.substringBeforeLast("a", null)    = "a"
     * StringUtil.substringBeforeLast("a", "")      = "a"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str       �??�?
     * @param separator �??索�????�?��
     * @return �?���?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String substringBeforeLast(String str, String separator) {
        if ((str == null) || (separator == null) || (str.length() == 0)
                || (separator.length() == 0)) {
            return str;
        }

        int pos = str.lastIndexOf(separator);

        if (pos == -1) {
            return str;
        }

        return str.substring(0, pos);
    }

    /**
     * ??????�?��??????串�????�?��??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�?????�?���?code>null</code>????��?该�?串�???????�??串�?
     * <p/>
     * <pre>
     * StringUtil.substringAfterLast(null, *)      = null
     * StringUtil.substringAfterLast("", *)        = ""
     * StringUtil.substringAfterLast(*, "")        = ""
     * StringUtil.substringAfterLast(*, null)      = ""
     * StringUtil.substringAfterLast("abc", "a")   = "bc"
     * StringUtil.substringAfterLast("abcba", "b") = "a"
     * StringUtil.substringAfterLast("abc", "c")   = ""
     * StringUtil.substringAfterLast("a", "a")     = ""
     * StringUtil.substringAfterLast("a", "z")     = ""
     * </pre>
     * <p/>
     * </p>
     *
     * @param str       �??�?
     * @param separator �??索�????�?��
     * @return �?���?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String substringAfterLast(String str, String separator) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }

        if ((separator == null) || (separator.length() == 0)) {
            return EMPTY_STRING;
        }

        int pos = str.lastIndexOf(separator);

        if ((pos == -1) || (pos == (str.length() - separator.length()))) {
            return EMPTY_STRING;
        }

        return str.substring(pos + separator.length());
    }

    /**
     * ?????????�????��次�??��??��?�?��??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�?????�?���?code>null</code>�??�?? <code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.substringBetween(null, *)            = null
     * StringUtil.substringBetween("", "")             = ""
     * StringUtil.substringBetween("", "tag")          = null
     * StringUtil.substringBetween("tagabctag", null)  = null
     * StringUtil.substringBetween("tagabctag", "")    = ""
     * StringUtil.substringBetween("tagabctag", "tag") = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �??�?
     * @param tag �??索�????�?��
     * @return �?���?????�?���?code>null</code>????��????�?���??�??
     * <code>null</code>
     */
    public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag, 0);
    }

    /**
     * ???两个???�???��?�?��??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�?????�?���?code>null</code>�??�?? <code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.substringBetween(null, *, *)          = null
     * StringUtil.substringBetween("", "", "")          = ""
     * StringUtil.substringBetween("", "", "tag")       = null
     * StringUtil.substringBetween("", "tag", "tag")    = null
     * StringUtil.substringBetween("yabcz", null, null) = null
     * StringUtil.substringBetween("yabcz", "", "")     = ""
     * StringUtil.substringBetween("yabcz", "y", "z")   = "abc"
     * StringUtil.substringBetween("yabczyabcz", "y", "z")   = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str   �??�?
     * @param open  �??索�????�?��1
     * @param close �??索�????�?��2
     * @return �?���?????�?���?code>null</code>????��????�?���??�??
     * <code>null</code>
     */
    public static String substringBetween(String str, String open, String close) {
        return substringBetween(str, open, close, 0);
    }

    /**
     * ???两个???�???��?�?��??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�?????�?���?code>null</code>�??�?? <code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.substringBetween(null, *, *)          = null
     * StringUtil.substringBetween("", "", "")          = ""
     * StringUtil.substringBetween("", "", "tag")       = null
     * StringUtil.substringBetween("", "tag", "tag")    = null
     * StringUtil.substringBetween("yabcz", null, null) = null
     * StringUtil.substringBetween("yabcz", "", "")     = ""
     * StringUtil.substringBetween("yabcz", "y", "z")   = "abc"
     * StringUtil.substringBetween("yabczyabcz", "y", "z")   = "abc"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str       �??�?
     * @param open      �??索�????�?��1
     * @param close     �??索�????�?��2
     * @param fromIndex �??�?ndex�??�?
     * @return �?���?????�?���?code>null</code>????��????�?���??�??
     * <code>null</code>
     */
    public static String substringBetween(String str, String open,
                                          String close, int fromIndex) {
        if ((str == null) || (open == null) || (close == null)) {
            return null;
        }

        int start = str.indexOf(open, fromIndex);

        if (start != -1) {
            int end = str.indexOf(close, start + open.length());

            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }

        return null;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ???�???? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ????????code>Character.isWhitespace(char)</code>�??�????��?��?
     * <p/>
     * <pre>
     * StringUtil.deleteWhitespace(null)         = null
     * StringUtil.deleteWhitespace("")           = ""
     * StringUtil.deleteWhitespace("abc")        = "abc"
     * StringUtil.deleteWhitespace("   ab  c  ") = "abc"
     * </pre>
     *
     * @param str �?????�??�?
     * @return ?�空?��????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String deleteWhitespace(String str) {
        if (str == null) {
            return null;
        }

        int sz = str.length();
        StringBuffer buffer = new StringBuffer(sz);

        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                buffer.append(str.charAt(i));
            }
        }

        return buffer.toString();
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ?��?�?��?? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ?��???????串�?????��?�?��?��????串�?
     * <p/>
     * <p>
     * �??�??串为<code>null</code>?????code>null</code>�?????�??串为
     * <code>null</code>�??�?????�?��??
     * <p/>
     * <pre>
     * StringUtil.replaceOnce(null, *, *)        = null
     * StringUtil.replaceOnce("", *, *)          = ""
     * StringUtil.replaceOnce("aba", null, null) = "aba"
     * StringUtil.replaceOnce("aba", null, null) = "aba"
     * StringUtil.replaceOnce("aba", "a", null)  = "aba"
     * StringUtil.replaceOnce("aba", "a", "")    = "ba"
     * StringUtil.replaceOnce("aba", "a", "z")   = "zba"
     * </pre>
     * <p/>
     * </p>
     *
     * @param text �?????�??�?
     * @param repl �??索�?�?��
     * @param with ?��?�??�?
     * @return �???��????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String replaceOnce(String text, String repl, String with) {
        return replace(text, repl, with, 1);
    }

    /**
     * ?��???????串�??��?????��????串�?
     * <p/>
     * <p>
     * �??�??串为<code>null</code>?????code>null</code>�?????�??串为
     * <code>null</code>�??�?????�?��??
     * <p/>
     * <pre>
     * StringUtil.replace(null, *, *)        = null
     * StringUtil.replace("", *, *)          = ""
     * StringUtil.replace("aba", null, null) = "aba"
     * StringUtil.replace("aba", null, null) = "aba"
     * StringUtil.replace("aba", "a", null)  = "aba"
     * StringUtil.replace("aba", "a", "")    = "b"
     * StringUtil.replace("aba", "a", "z")   = "zbz"
     * </pre>
     * <p/>
     * </p>
     *
     * @param text �?????�??�?
     * @param repl �??索�?�?��
     * @param with ?��?�??�?
     * @return �???��????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String replace(String text, String repl, String with) {
        return replace(text, repl, with, -1);
    }

    /**
     * ?��???????串�??��????????��?
     * <p/>
     * <p>
     * �??�??串为<code>null</code>?????code>null</code>�?????�??串为
     * <code>null</code>�??�?????�?��??
     * <p/>
     * <pre>
     * StringUtil.replace(null, *, *, *)         = null
     * StringUtil.replace("", *, *, *)           = ""
     * StringUtil.replace("abaa", null, null, 1) = "abaa"
     * StringUtil.replace("abaa", null, null, 1) = "abaa"
     * StringUtil.replace("abaa", "a", null, 1)  = "abaa"
     * StringUtil.replace("abaa", "a", "", 1)    = "baa"
     * StringUtil.replace("abaa", "a", "z", 0)   = "abaa"
     * StringUtil.replace("abaa", "a", "z", 1)   = "zbaa"
     * StringUtil.replace("abaa", "a", "z", 2)   = "zbza"
     * StringUtil.replace("abaa", "a", "z", -1)  = "zbzz"
     * </pre>
     * <p/>
     * </p>
     *
     * @param text �?????�??�?
     * @param repl �??索�?�?��
     * @param with ?��?�??�?
     * @param max  maximum number of values to replace, or <code>-1</code> if no
     *             maximum
     * @return �???��????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String replace(String text, String repl, String with, int max) {
        if ((text == null) || (repl == null) || (with == null)
                || (repl.length() == 0) || (max == 0)) {
            return text;
        }

        StringBuffer buf = new StringBuffer(text.length());
        int start = 0;
        int end = 0;

        while ((end = text.indexOf(repl, start)) != -1) {
            buf.append(text.substring(start, end)).append(with);
            start = end + repl.length();

            if (--max == 0) {
                break;
            }
        }

        buf.append(text.substring(start));
        return buf.toString();
    }

    /**
     * �??�?���?????�??�??�???��????�??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>?????code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.replaceChars(null, *, *)        = null
     * StringUtil.replaceChars("", *, *)          = ""
     * StringUtil.replaceChars("abcba", 'b', 'y') = "aycya"
     * StringUtil.replaceChars("abcba", 'z', 'y') = "abcba"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str         �?????�??�?
     * @param searchChar  �??索�?�??
     * @param replaceChar ?��?�??
     * @return �???��????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String replaceChars(String str, char searchChar,
                                      char replaceChar) {
        if (str == null) {
            return null;
        }

        return str.replace(searchChar, replaceChar);
    }

    /**
     * �??�?���?????�??�??�???��????�??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>
     * ?????code>null</code>??????索�?�?���?code>null</code>??���??�?????�?��??
     * </p>
     * <p/>
     * <p>
     * �??�?
     * <code>replaceChars(&quot;hello&quot;, &quot;ho&quot;, &quot;jy&quot;) = jelly</code>
     * ??
     * </p>
     * <p/>
     * <p>
     * ??��??���??串�??��?�??串�?�?????�????���??串�??��?�??串�?�??�?????�??�???��?
     * �????���??串�??��?�??串�?�??缺�????�??�?��?��?
     * <p/>
     * <pre>
     * StringUtil.replaceChars(null, *, *)           = null
     * StringUtil.replaceChars("", *, *)             = ""
     * StringUtil.replaceChars("abc", null, *)       = "abc"
     * StringUtil.replaceChars("abc", "", *)         = "abc"
     * StringUtil.replaceChars("abc", "b", null)     = "ac"
     * StringUtil.replaceChars("abc", "b", "")       = "ac"
     * StringUtil.replaceChars("abcba", "bc", "yz")  = "ayzya"
     * StringUtil.replaceChars("abcba", "bc", "y")   = "ayya"
     * StringUtil.replaceChars("abcba", "bc", "yzx") = "ayzya"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str          �?????�??�?
     * @param searchChars  �??索�?�??�?
     * @param replaceChars ?��?�??�?
     * @return �???��????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String replaceChars(String str, String searchChars,
                                      String replaceChars) {
        if ((str == null) || (str.length() == 0) || (searchChars == null)
                || (searchChars.length() == 0)) {
            return str;
        }

        char[] chars = str.toCharArray();
        int len = chars.length;
        boolean modified = false;

        for (int i = 0, isize = searchChars.length(); i < isize; i++) {
            char searchChar = searchChars.charAt(i);

            if ((replaceChars == null) || (i >= replaceChars.length())) {
                // ???
                int pos = 0;

                for (int j = 0; j < len; j++) {
                    if (chars[j] != searchChar) {
                        chars[pos++] = chars[j];
                    } else {
                        modified = true;
                    }
                }

                len = pos;
            } else {
                // ?��?
                for (int j = 0; j < len; j++) {
                    if (chars[j] == searchChar) {
                        chars[j] = replaceChars.charAt(i);
                        modified = true;
                    }
                }
            }
        }

        if (!modified) {
            return str;
        }

        return new String(chars, 0, len);
    }

    /**
     * �??�??�?��?��?�??�??串�????
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>
     * ??�??索�??��?�??�?code>0</code>�?????索�??��?�??�??�??串�??�度?��??????
     * <p/>
     * <pre>
     * StringUtil.overlay(null, *, *, *)            = null
     * StringUtil.overlay("", "abc", 0, 0)          = "abc"
     * StringUtil.overlay("abcdef", null, 2, 4)     = "abef"
     * StringUtil.overlay("abcdef", "", 2, 4)       = "abef"
     * StringUtil.overlay("abcdef", "", 4, 2)       = "abef"
     * StringUtil.overlay("abcdef", "zzzz", 2, 4)   = "abzzzzef"
     * StringUtil.overlay("abcdef", "zzzz", 4, 2)   = "abzzzzef"
     * StringUtil.overlay("abcdef", "zzzz", -1, 4)  = "zzzzef"
     * StringUtil.overlay("abcdef", "zzzz", 2, 8)   = "abzzzz"
     * StringUtil.overlay("abcdef", "zzzz", -2, -3) = "zzzzabcdef"
     * StringUtil.overlay("abcdef", "zzzz", 8, 10)  = "abcdefzzzz"
     * </pre>
     * <p/>
     * </p>
     *
     * @param str     �?????�??�?
     * @param overlay ?��?�?????�?��
     * @param start   起�?索�?
     * @param end     �??索�?
     * @return �????????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String overlay(String str, String overlay, int start, int end) {
        if (str == null) {
            return null;
        }

        if (overlay == null) {
            overlay = EMPTY_STRING;
        }

        int len = str.length();

        if (start < 0) {
            start = 0;
        }

        if (start > len) {
            start = len;
        }

        if (end < 0) {
            end = 0;
        }

        if (end > len) {
            end = len;
        }

        if (start > end) {
            int temp = start;

            start = end;
            end = temp;
        }

        return new StringBuffer((len + start) - end + overlay.length() + 1)
                .append(str.substring(0, start)).append(overlay)
                .append(str.substring(end)).toString();
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* Perl�????homp??hop?��??? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ???�??串�?尾�??��?�??�??�??串�?以�?�??尾�????�??�????
     * <p/>
     * <p>
     * ?��?�??�????���?quot;<code>\n</code>&quot;??quot;<code>\r</code>
     * &quot;??quot;<code>\r\n</code> &quot;??
     * <p/>
     * <pre>
     * StringUtil.chomp(null)          = null
     * StringUtil.chomp("")            = ""
     * StringUtil.chomp("abc \r")      = "abc "
     * StringUtil.chomp("abc\n")       = "abc"
     * StringUtil.chomp("abc\r\n")     = "abc"
     * StringUtil.chomp("abc\r\n\r\n") = "abc\r\n"
     * StringUtil.chomp("abc\n\r")     = "abc\n"
     * StringUtil.chomp("abc\n\rabc")  = "abc\n\rabc"
     * StringUtil.chomp("\r")          = ""
     * StringUtil.chomp("\n")          = ""
     * StringUtil.chomp("\r\n")        = ""
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return �?��?��?�?��???�?���?????�??串为<code>null</code>�??�??
     * <code>null</code>
     */
    public static String chomp(String str) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }

        if (str.length() == 1) {
            char ch = str.charAt(0);

            if ((ch == '\r') || (ch == '\n')) {
                return EMPTY_STRING;
            } else {
                return str;
            }
        }

        int lastIdx = str.length() - 1;
        char last = str.charAt(lastIdx);

        if (last == '\n') {
            if (str.charAt(lastIdx - 1) == '\r') {
                lastIdx--;
            }
        } else if (last == '\r') {
        } else {
            lastIdx++;
        }

        return str.substring(0, lastIdx);
    }

    /**
     * ???�??串�?尾�????�??串�?�??�??串�?以�?�??串�?尾�????�??�????
     * <p/>
     * <pre>
     * StringUtil.chomp(null, *)         = null
     * StringUtil.chomp("", *)           = ""
     * StringUtil.chomp("foobar", "bar") = "foo"
     * StringUtil.chomp("foobar", "baz") = "foobar"
     * StringUtil.chomp("foo", "foo")    = ""
     * StringUtil.chomp("foo ", "foo")   = "foo "
     * StringUtil.chomp(" foo", "foo")   = " "
     * StringUtil.chomp("foo", "foooo")  = "foo"
     * StringUtil.chomp("foo", "")       = "foo"
     * StringUtil.chomp("foo", null)     = "foo"
     * </pre>
     *
     * @param str       �?????�??�?
     * @param separator �???��?�??�?
     * @return �?��???�??串�?尾�?�??串�?�?????�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String chomp(String str, String separator) {
        if ((str == null) || (str.length() == 0) || (separator == null)) {
            return str;
        }

        if (str.endsWith(separator)) {
            return str.substring(0, str.length() - separator.length());
        }

        return str;
    }

    /**
     * ??????�?���????
     * <p/>
     * <p>
     * �??�??串以<code>\r\n</code>�?���????????�?��??
     * <p/>
     * <pre>
     * StringUtil.chop(null)          = null
     * StringUtil.chop("")            = ""
     * StringUtil.chop("abc \r")      = "abc "
     * StringUtil.chop("abc\n")       = "abc"
     * StringUtil.chop("abc\r\n")     = "abc"
     * StringUtil.chop("abc")         = "ab"
     * StringUtil.chop("abc\nabc")    = "abc\nab"
     * StringUtil.chop("a")           = ""
     * StringUtil.chop("\r")          = ""
     * StringUtil.chop("\n")          = ""
     * StringUtil.chop("\r\n")        = ""
     * </pre>
     * <p/>
     * </p>
     *
     * @param str �?????�??�?
     * @return ??????�?���?????�?���?????�??�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String chop(String str) {
        if (str == null) {
            return null;
        }

        int strLen = str.length();

        if (strLen < 2) {
            return EMPTY_STRING;
        }

        int lastIdx = strLen - 1;
        String ret = str.substring(0, lastIdx);
        char last = str.charAt(lastIdx);

        if (last == '\n') {
            if (ret.charAt(lastIdx - 1) == '\r') {
                return ret.substring(0, lastIdx - 1);
            }
        }

        return ret;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ???/对�?�??串�? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??�??�?��???n???
     * <p/>
     * <pre>
     * StringUtil.repeat(null, 2)   = null
     * StringUtil.repeat("", 0)     = ""
     * StringUtil.repeat("", 2)     = ""
     * StringUtil.repeat("a", 3)    = "aaa"
     * StringUtil.repeat("ab", 2)   = "abab"
     * StringUtil.repeat("abcd", 2) = "abcdabcd"
     * StringUtil.repeat("a", -2)   = ""
     * </pre>
     *
     * @param str    �??�??�??�?
     * @param repeat ???次�?�?????�?code>0</code>�?????<code>0</code>
     * @return ???n次�?�??串�?�?????�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String repeat(String str, int repeat) {
        if (str == null) {
            return null;
        }

        if (repeat <= 0) {
            return EMPTY_STRING;
        }

        int inputLength = str.length();

        if ((repeat == 1) || (inputLength == 0)) {
            return str;
        }

        int outputLength = inputLength * repeat;

        switch (inputLength) {
            case 1:

                char ch = str.charAt(0);
                char[] output1 = new char[outputLength];

                for (int i = repeat - 1; i >= 0; i--) {
                    output1[i] = ch;
                }

                return new String(output1);

            case 2:

                char ch0 = str.charAt(0);
                char ch1 = str.charAt(1);
                char[] output2 = new char[outputLength];

                for (int i = (repeat * 2) - 2; i >= 0; i--, i--) {
                    output2[i] = ch0;
                    output2[i + 1] = ch1;
                }

                return new String(output2);

            default:

                StringBuffer buf = new StringBuffer(outputLength);

                for (int i = 0; i < repeat; i++) {
                    buf.append(str);
                }

                return buf.toString();
        }
    }

    /**
     * ?��?并左对�?�??串�??�空??code>' '</code>�???�边??
     * <p/>
     * <pre>
     * StringUtil.alignLeft(null, *)   = null
     * StringUtil.alignLeft("", 3)     = "   "
     * StringUtil.alignLeft("bat", 3)  = "bat"
     * StringUtil.alignLeft("bat", 5)  = "bat  "
     * StringUtil.alignLeft("bat", 1)  = "bat"
     * StringUtil.alignLeft("bat", -1) = "bat"
     * </pre>
     *
     * @param str  �??�??�??�?
     * @param size ?��?�??串�????宽度
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String alignLeft(String str, int size) {
        return alignLeft(str, size, ' ');
    }

    /**
     * ?��?并左对�?�??串�??��?�??�?��???边�?
     * <p/>
     * <pre>
     * StringUtil.alignLeft(null, *, *)     = null
     * StringUtil.alignLeft("", 3, 'z')     = "zzz"
     * StringUtil.alignLeft("bat", 3, 'z')  = "bat"
     * StringUtil.alignLeft("bat", 5, 'z')  = "batzz"
     * StringUtil.alignLeft("bat", 1, 'z')  = "bat"
     * StringUtil.alignLeft("bat", -1, 'z') = "bat"
     * </pre>
     *
     * @param str     �??�??�??�?
     * @param size    ?��?�??串�????宽度
     * @param padChar �??�??
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String alignLeft(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }

        int pads = size - str.getBytes().length;

        if (pads <= 0) {
            return str;
        }

        return alignLeft(str, size, String.valueOf(padChar));
    }

    /**
     * ?��?并左对�?�??串�??��?�??�?���???�边??
     * <p/>
     * <pre>
     * StringUtil.alignLeft(null, *, *)      = null
     * StringUtil.alignLeft("", 3, "z")      = "zzz"
     * StringUtil.alignLeft("bat", 3, "yz")  = "bat"
     * StringUtil.alignLeft("bat", 5, "yz")  = "batyz"
     * StringUtil.alignLeft("bat", 8, "yz")  = "batyzyzy"
     * StringUtil.alignLeft("bat", 1, "yz")  = "bat"
     * StringUtil.alignLeft("bat", -1, "yz") = "bat"
     * StringUtil.alignLeft("bat", 5, null)  = "bat  "
     * StringUtil.alignLeft("bat", 5, "")    = "bat  "
     * </pre>
     *
     * @param str    �??�??�??�?
     * @param size   ?��?�??串�????宽度
     * @param padStr �??�??�?
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String alignLeft(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }

        if ((padStr == null) || (padStr.length() == 0)) {
            padStr = " ";
        }

        int padLen = padStr.getBytes().length;
        int strLen = str.getBytes().length;
        int pads = size - strLen;

        if (pads <= 0) {
            return str;
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();

            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }

            return str.concat(new String(padding));
        }
    }

    /**
     * ?��?并�?对�?�??串�??�空??code>' '</code>�??�?��??
     * <p/>
     * <pre>
     * StringUtil.alignRight(null, *)   = null
     * StringUtil.alignRight("", 3)     = "   "
     * StringUtil.alignRight("bat", 3)  = "bat"
     * StringUtil.alignRight("bat", 5)  = "  bat"
     * StringUtil.alignRight("bat", 1)  = "bat"
     * StringUtil.alignRight("bat", -1) = "bat"
     * </pre>
     *
     * @param str  �??�??�??�?
     * @param size ?��?�??串�????宽度
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String alignRight(String str, int size) {
        return alignRight(str, size, ' ');
    }

    /**
     * ?��?并�?对�?�??串�??��?�??�?��??��边�?
     * <p/>
     * <pre>
     * StringUtil.alignRight(null, *, *)     = null
     * StringUtil.alignRight("", 3, 'z')     = "zzz"
     * StringUtil.alignRight("bat", 3, 'z')  = "bat"
     * StringUtil.alignRight("bat", 5, 'z')  = "zzbat"
     * StringUtil.alignRight("bat", 1, 'z')  = "bat"
     * StringUtil.alignRight("bat", -1, 'z') = "bat"
     * </pre>
     *
     * @param str     �??�??�??�?
     * @param size    ?��?�??串�????宽度
     * @param padChar �??�??
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String alignRight(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }

        int pads = size - str.getBytes().length;

        if (pads <= 0) {
            return str;
        }

        return alignRight(str, size, String.valueOf(padChar));
    }

    /**
     * ?��?并�?对�?�??串�??��?�??�?���??�?��??
     * <p/>
     * <pre>
     * StringUtil.alignRight(null, *, *)      = null
     * StringUtil.alignRight("", 3, "z")      = "zzz"
     * StringUtil.alignRight("bat", 3, "yz")  = "bat"
     * StringUtil.alignRight("bat", 5, "yz")  = "yzbat"
     * StringUtil.alignRight("bat", 8, "yz")  = "yzyzybat"
     * StringUtil.alignRight("bat", 1, "yz")  = "bat"
     * StringUtil.alignRight("bat", -1, "yz") = "bat"
     * StringUtil.alignRight("bat", 5, null)  = "  bat"
     * StringUtil.alignRight("bat", 5, "")    = "  bat"
     * </pre>
     *
     * @param str    �??�??�??�?
     * @param size   ?��?�??串�????宽度
     * @param padStr �??�??�?
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String alignRight(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }

        if ((padStr == null) || (padStr.length() == 0)) {
            padStr = " ";
        }

        int padLen = padStr.getBytes().length;
        int strLen = str.getBytes().length;
        int pads = size - strLen;

        if (pads <= 0) {
            return str;
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();

            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }

            return new String(padding).concat(str);
        }
    }

    /**
     * ?��?并�?�??�?���??空�?<code>' '</code>�??两边??
     * <p/>
     * <pre>
     * StringUtil.center(null, *)   = null
     * StringUtil.center("", 4)     = "    "
     * StringUtil.center("ab", -1)  = "ab"
     * StringUtil.center("ab", 4)   = " ab "
     * StringUtil.center("abcd", 2) = "abcd"
     * StringUtil.center("a", 4)    = " a  "
     * </pre>
     *
     * @param str  �??�??�??�?
     * @param size ?��?�??串�????宽度
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String center(String str, int size) {
        return center(str, size, ' ');
    }

    /**
     * ?��?并�?�??�?���?????�??�??两边??
     * <p/>
     * <pre>
     * StringUtil.center(null, *, *)     = null
     * StringUtil.center("", 4, ' ')     = "    "
     * StringUtil.center("ab", -1, ' ')  = "ab"
     * StringUtil.center("ab", 4, ' ')   = " ab "
     * StringUtil.center("abcd", 2, ' ') = "abcd"
     * StringUtil.center("a", 4, ' ')    = " a  "
     * StringUtil.center("a", 4, 'y')    = "yayy"
     * </pre>
     *
     * @param str     �??�??�??�?
     * @param size    ?��?�??串�????宽度
     * @param padChar �??�??
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String center(String str, int size, char padChar) {
        if ((str == null) || (size <= 0)) {
            return str;
        }

        int strLen = str.length();
        int pads = size - strLen;

        if (pads <= 0) {
            return str;
        }

        str = alignRight(str, strLen + (pads / 2), padChar);
        str = alignLeft(str, size, padChar);
        return str;
    }

    /**
     * ?��?并�?�??�?���?????�??串填??��边�?
     * <p/>
     * <pre>
     * StringUtil.center(null, *, *)     = null
     * StringUtil.center("", 4, " ")     = "    "
     * StringUtil.center("ab", -1, " ")  = "ab"
     * StringUtil.center("ab", 4, " ")   = " ab "
     * StringUtil.center("abcd", 2, " ") = "abcd"
     * StringUtil.center("a", 4, " ")    = " a  "
     * StringUtil.center("a", 4, "yz")   = "yayz"
     * StringUtil.center("abc", 7, null) = "  abc  "
     * StringUtil.center("abc", 7, "")   = "  abc  "
     * </pre>
     *
     * @param str    �??�??�??�?
     * @param size   ?��?�??串�????宽度
     * @param padStr �??�??�?
     * @return ?��????�??串�?�??�??串为<code>null</code>�??�??<code>null</code>
     */
    public static String center(String str, int size, String padStr) {
        if ((str == null) || (size <= 0)) {
            return str;
        }

        if ((padStr == null) || (padStr.length() == 0)) {
            padStr = " ";
        }

        int strLen = str.length();
        int pads = size - strLen;

        if (pads <= 0) {
            return str;
        }

        str = alignRight(str, strLen + (pads / 2), padStr);
        str = alignLeft(str, size, padStr);
        return str;
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ??���??串�? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * ??���??串中???�?���??
     * <p/>
     * <p>
     * �??�??串为<code>null</code>�??�??<code>null</code>??
     * </p>
     * <p/>
     * <pre>
     * StringUtil.reverse(null)  = null
     * StringUtil.reverse("")    = ""
     * StringUtil.reverse("bat") = "tab"
     * </pre>
     *
     * @param str �??�??�??�?
     * @return ??��???�??串�?�?????�?���?code>null</code>�??�??<code>null</code>
     */
    public static String reverse(String str) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }

        return new StringBuffer(str).reverse().toString();
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* ???�??串�?缩�??? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??�?���?????�??�??缩�?�??�?? �?Now is the time for all good
     * men"�????Now is the time for..."??
     * <p/>
     * <ul>
     * <li>
     * �??<code>str</code>�?code>maxWidth</code>????��?�??�?</li>
     * <li>
     * ???�??�????��?��?<code>substring(str, 0, max-3) + "..."</code>�?</li>
     * <li>
     * �??<code>maxWidth</code>�??<code>4</code>???
     * <code>IllegalArgumentException</code>�?</li>
     * <li>
     * �?????�?���???��?�??�??<code>maxWidth</code>??</li>
     * </ul>
     * <p/>
     * <pre>
     * StringUtil.abbreviate(null, *)      = null
     * StringUtil.abbreviate("", 4)        = ""
     * StringUtil.abbreviate("abcdefg", 6) = "abc..."
     * StringUtil.abbreviate("abcdefg", 7) = "abcdefg"
     * StringUtil.abbreviate("abcdefg", 8) = "abcdefg"
     * StringUtil.abbreviate("abcdefg", 4) = "a..."
     * StringUtil.abbreviate("abcdefg", 3) = IllegalArgumentException
     * </pre>
     *
     * @param str      �???��?�??�?
     * @param maxWidth ??��?�度�??�??<code>4</code>�?????�?code>4</code>�?????
     *                 <code>4</code>
     * @return �??串缩?��?�?????�??串为<code>null</code>?????code>null</code>
     */
    public static String abbreviate(String str, int maxWidth) {
        return abbreviate(str, 0, maxWidth);
    }

    /**
     * �??�?���?????�??�??缩�?�??�?? �?Now is the time for all good
     * men"�????...is the time for..."??
     * <p/>
     * <p>
     * ??code>abbreviate(String, int)</code>类似�????????�?��??��边�????移�???
     * 注�?�??�?��???�??�??????��??��????�?��???�?���??�???��??��????�?���??
     * </p>
     * <p/>
     * <p>
     * �?????�?���???��?�??�??<code>maxWidth</code>??
     * <p/>
     * <pre>
     * StringUtil.abbreviate(null, *, *)                = null
     * StringUtil.abbreviate("", 0, 4)                  = ""
     * StringUtil.abbreviate("abcdefghijklmno", -1, 10) = "abcdefg..."
     * StringUtil.abbreviate("abcdefghijklmno", 0, 10)  = "abcdefg..."
     * StringUtil.abbreviate("abcdefghijklmno", 1, 10)  = "abcdefg..."
     * StringUtil.abbreviate("abcdefghijklmno", 4, 10)  = "abcdefg..."
     * StringUtil.abbreviate("abcdefghijklmno", 5, 10)  = "...fghi..."
     * StringUtil.abbreviate("abcdefghijklmno", 6, 10)  = "...ghij..."
     * StringUtil.abbreviate("abcdefghijklmno", 8, 10)  = "...ijklmno"
     * StringUtil.abbreviate("abcdefghijklmno", 10, 10) = "...ijklmno"
     * StringUtil.abbreviate("abcdefghijklmno", 12, 10) = "...ijklmno"
     * StringUtil.abbreviate("abcdefghij", 0, 3)        = IllegalArgumentException
     * StringUtil.abbreviate("abcdefghij", 5, 6)        = IllegalArgumentException
     * </pre>
     * <p/>
     * </p>
     *
     * @param str      �???��?�??�?
     * @param offset   �?��???移�?
     * @param maxWidth ??��?�度�??�??<code>4</code>�?????�?code>4</code>�?????
     *                 <code>4</code>
     * @return �??串缩?��?�?????�??串为<code>null</code>?????code>null</code>
     */
    public static String abbreviate(String str, int offset, int maxWidth) {
        if (str == null) {
            return null;
        }

        // �????��宽度
        if (maxWidth < 4) {
            maxWidth = 4;
        }

        if (str.length() <= maxWidth) {
            return str;
        }

        if (offset > str.length()) {
            offset = str.length();
        }

        if ((str.length() - offset) < (maxWidth - 3)) {
            offset = str.length() - (maxWidth - 3);
        }

        if (offset <= 4) {
            return str.substring(0, maxWidth - 3) + "...";
        }

        // �????��宽度
        if (maxWidth < 7) {
            maxWidth = 7;
        }

        if ((offset + (maxWidth - 3)) < str.length()) {
            return "..." + abbreviate(str.substring(offset), maxWidth - 3);
        }

        return "..." + str.substring(str.length() - (maxWidth - 3));
    }

	/*
	 * ==========================================================================
	 * ==
	 */
	/* �??两个�??串�?�???? */
	/*                                                                              */
	/* ?��?�??串�??��?�??�??�??�?��???似度?? */
	/*
	 * ==========================================================================
	 * ==
	 */

    /**
     * �??两个�??串�????�??�??�?���?????�?���??串�?????��???
     * <p/>
     * <pre>
     * StringUtil.difference("i am a machine", "i am a robot")  = "robot"
     * StringUtil.difference(null, null)                        = null
     * StringUtil.difference("", "")                            = ""
     * StringUtil.difference("", null)                          = ""
     * StringUtil.difference("", "abc")                         = "abc"
     * StringUtil.difference("abc", "")                         = ""
     * StringUtil.difference("abc", "abc")                      = ""
     * StringUtil.difference("ab", "abxyz")                     = "xyz"
     * StringUtil.difference("abcde", "abxyz")                  = "xyz"
     * StringUtil.difference("abcde", "xyz")                    = "xyz"
     * </pre>
     *
     * @param str1 �??�?
     * @param str2 �??�?
     * @return �??�??�?���?????�?���??串�?????��??????���??�?��?��?�??�??空�?�?��
     * <code>""</code>
     */
    public static String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }

        if (str2 == null) {
            return str1;
        }

        int index = indexOfDifference(str1, str2);

        if (index == -1) {
            return EMPTY_STRING;
        }

        return str2.substring(index);
    }

    /**
     * �??两个�??串�????两�?�?���??�????���????
     * <p/>
     * <pre>
     * StringUtil.indexOfDifference("i am a machine", "i am a robot")   = 7
     * StringUtil.indexOfDifference(null, null)                         = -1
     * StringUtil.indexOfDifference("", null)                           = -1
     * StringUtil.indexOfDifference("", "")                             = -1
     * StringUtil.indexOfDifference("", "abc")                          = 0
     * StringUtil.indexOfDifference("abc", "")                          = 0
     * StringUtil.indexOfDifference("abc", "abc")                       = -1
     * StringUtil.indexOfDifference("ab", "abxyz")                      = 2
     * StringUtil.indexOfDifference("abcde", "abxyz")                   = 2
     * StringUtil.indexOfDifference("abcde", "xyz")                     = 0
     * </pre>
     *
     * @param str1 �??�?
     * @param str2 �??�?
     * @return 两�?�?���??产�?�????���??�????���??串�?????????code>-1</code>
     */
    public static int indexOfDifference(String str1, String str2) {
        if ((str1 == str2) || (str1 == null) || (str2 == null)) {
            return -1;
        }

        int i;

        for (i = 0; (i < str1.length()) && (i < str2.length()); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }

        if ((i < str2.length()) || (i < str1.length())) {
            return i;
        }

        return -1;
    }

    /**
     * ???两个�??串�??�似�??<code>0</code>代表�??串�?�???��?�?��表示�??串�?�????
     * <p/>
     * <p>
     * �?���?????<a
     * href="http://www.merriampark.com/ld.htm">http://www.merriampark
     * .com/ld.htm</a>?? �??�?????�??�?�???��?�?��2???�?????????��??��????骤�???
     * </p>
     * <p/>
     * <pre>
     * StringUtil.getLevenshteinDistance(null, *)             = IllegalArgumentException
     * StringUtil.getLevenshteinDistance(*, null)             = IllegalArgumentException
     * StringUtil.getLevenshteinDistance("","")               = 0
     * StringUtil.getLevenshteinDistance("","a")              = 1
     * StringUtil.getLevenshteinDistance("aaapppp", "")       = 7
     * StringUtil.getLevenshteinDistance("frog", "fog")       = 1
     * StringUtil.getLevenshteinDistance("fly", "ant")        = 3
     * StringUtil.getLevenshteinDistance("elephant", "hippo") = 7
     * StringUtil.getLevenshteinDistance("hippo", "elephant") = 7
     * StringUtil.getLevenshteinDistance("hippo", "zzzzzzzz") = 8
     * StringUtil.getLevenshteinDistance("hello", "hallo")    = 1
     * </pre>
     *
     * @param s �??�??�?���?????<code>null</code>�?????空�?�?��
     * @param t �??�??�?���?????<code>null</code>�?????空�?�?��
     * @return ?�似�??
     */
    public static int getLevenshteinDistance(String s, String t) {
        s = defaultIfNull(s);
        t = defaultIfNull(t);

        int[][] d; // matrix
        int n; // length of s
        int m; // length of t
        int i; // iterates through s
        int j; // iterates through t
        char s_i; // ith character of s
        char t_j; // jth character of t
        int cost; // cost

        // Step 1
        n = s.length();
        m = t.length();

        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        d = new int[n + 1][m + 1];

        // Step 2
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }

        // Step 3
        for (i = 1; i <= n; i++) {
            s_i = s.charAt(i - 1);

            // Step 4
            for (j = 1; j <= m; j++) {
                t_j = t.charAt(j - 1);

                // Step 5
                if (s_i == t_j) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                // Step 6
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]
                        + cost);
            }
        }

        // Step 7
        return d[n][m];
    }

    /**
     * ??????�??串�?索�?�?���???��??��???
     *
     * @param inputString
     * @param matchTag
     * @param matchTimes
     * @return
     */
    public static int extIndexOf(String inputString, char matchTag,
                                 int matchTimes) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char temp = inputString.charAt(i);
            if (temp == matchTag) {
                count++;
                if (count == matchTimes) {
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * ???????��?
     *
     * @param a ?��?1
     * @param b ?��?2
     * @param c ?��?3
     * @return �?��?�中???�??
     */
    private static int min(int a, int b, int c) {
        if (b < a) {
            a = b;
        }

        if (c < a) {
            a = c;
        }

        return a;
    }

    /**
     * ???�??�?ize????��?�??�?
     *
     * @param size
     * @return
     */
    public String creatRandom(int size) {

        if (size <= 0) {
            size = 1;
        }
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < size; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();

    }

    public static String showDouble(double showdata) {
        BigDecimal bdRet = new BigDecimal(showdata);
        bdRet = bdRet.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bdRet.toString();
    }

    /**
     * ?��?�??串中??????�??
     *
     * @param str
     * @return
     */
    public static boolean isContainsChinese(String str) {
        final String regEx = "[\\u4e00-\\u9fa5]";
        final Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        return matcher.find();
    }

    /**
     * ?��?�??串�???��???????��????�?
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        if (StringUtil.isBlank(str)) {
            return false;
        }
        final String reg = "^1[0-9]{10}";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isNormalStr(char c) {
        int charInt = (int) c;
        return charInt >= 65 && charInt <= 90 || charInt >= 97 && charInt <= 122;
    }

    /**
     * 空�?<code>String</code>?��???
     */

    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    /**
     * �??�?��???�??�???��?
     * <p/>
     * <p>
     * ???�??�???��?????��?�??�?��??????就�????�?��??????�?���?code>null</code>�?
     * ?�?? <code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.split(null, *)                = null
     * StringUtil.split("", *)                  = []
     * StringUtil.split("abc def", null)        = ["abc", "def"]
     * StringUtil.split("abc def", " ")         = ["abc", "def"]
     * StringUtil.split("abc  def", " ")        = ["abc", "def"]
     * StringUtil.split(" ab:  cd::ef  ", ":")  = ["ab", "cd", "ef"]
     * StringUtil.split("abc.def", "")          = ["abc.def"]
     * </pre>
     * <p/>
     * </p>
     *
     * @param str            �???��?�??�?
     * @param separatorChars ???�?
     * @return ??????�??串�?�??�?????�?���?code>null</code>�??�??
     * <code>null</code>
     */
    public static String[] split(String str, String separatorChars) {
        return split(str, separatorChars, -1);
    }

    /**
     * �??�?��???�??�???��?
     * <p/>
     * <p>
     * ???�??�???��?????��?�??�?��??????就�????�?��??????�?���?code>null</code>�?
     * ?�?? <code>null</code>??
     * <p/>
     * <pre>
     * StringUtil.split(null, *, *)                 = null
     * StringUtil.split("", *, *)                   = []
     * StringUtil.split("ab cd ef", null, 0)        = ["ab", "cd", "ef"]
     * StringUtil.split("  ab   cd ef  ", null, 0)  = ["ab", "cd", "ef"]
     * StringUtil.split("ab:cd::ef", ":", 0)        = ["ab", "cd", "ef"]
     * StringUtil.split("ab:cd:ef", ":", 2)         = ["ab", "cdef"]
     * StringUtil.split("abc.def", "", 2)           = ["abc.def"]
     * </pre>
     * <p/>
     * </p>
     *
     * @param str            �???��?�??�?
     * @param separatorChars ???�?
     * @param max            �?????�????���??�?????�??�?�??表示?????
     * @return ??????�??串�?�??�?????�?���?code>null</code>�??�??
     * <code>null</code>
     */

    public static String[] split(String str, String separatorChars, int max) {
        if (str == null) {
            return null;
        }

        int length = str.length();

        if (length == 0) {
            return EMPTY_STRING_ARRAY;
        }
        List<String> list = new ArrayList<String>();
        int sizePlus1 = 1;
        int i = 0;
        int start = 0;
        boolean match = false;
        if (separatorChars == null) {
            // null表示使�?空�?�?��???�?
            while (i < length) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = length;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // �?????�??�?��1???�?
            char sep = separatorChars.charAt(0);

            while (i < length) {
                if (str.charAt(i) == sep) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = length;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                match = true;
                i++;
            }
        } else {
            // �????��
            while (i < length) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match) {
                        if (sizePlus1++ == max) {
                            i = length;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                match = true;
                i++;
            }
        }
        if (match) {
            list.add(str.substring(start, i));
        }
        return list.toArray(new String[list.size()]);
    }

    public static boolean isEmail(String mail) {
        return mail.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    }

    public static boolean isWebsite(String website) {
        if (null == website || "".equals(website.trim())) {
            return false;
        }
        // final String match = "[a-zA-z]+://[^\\s]*";
        // return website.matches(match);
        return website.contains("http://");
    }

    public static String formatPhone(String phone) {
        // +86 139 1879 0432
        String ret = "+86 ";
        ret += phone.substring(0, 3) + " " + phone.substring(3, 7) + " "
                + phone.substring(7);
        return ret;
    }

    public static boolean isValidMobile(String mobiles) {
        Pattern p = Pattern.compile("^1[0-9]{10}");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static int getUrlFiledIntValue(String url, String filed) {
        String tag = "&" + filed + "=";
        int s = url.indexOf(tag);
        int e = url.indexOf("&", s + tag.length());
        int value = 0;

        if (s != -1 && e != -1) {
            if (isNumeric(url.substring(s + tag.length(), e)))
                value = Integer.parseInt(url.substring(s + tag.length(), e));
        }
        return value;
    }

    public static String getUrlFiledStringValue(String url, String filed) {
        String tag = "&" + filed + "=";
        int s = url.indexOf(tag);
        int e = url.indexOf("&", s + tag.length());
        String value = null;

        if (s != -1 && e != -1) {
            value = url.substring(s + tag.length(), e);
        }
        return value;
    }

    public static String getUrlFiledValue(String url, String filed) {
        Uri uri = Uri.parse(url);
        return uri.getQueryParameter(filed);
    }

    public static String formatBigNumber(long number) {
        String str = "";
        if (number <= 9999) {
            str += number;
        } else if (number >= 10000) {
            int n = (int) (number / 10000);
            str = n + "��";
        }

        return str;
    }

    //
    //
    // /**
    // * ��ȡ���ִ�ƴ������ĸ��Ӣ�ļ������ַ��ַ�����
    // *
    // * @param chinese ���ִ�
    // * @return ����ƴ������ĸ
    // */
    // public static String getChsFirstLetter(String chinese) {
    // StringBuffer pybf = new StringBuffer();
    // char[] arr = chinese.toCharArray();
    // HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
    // defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    // defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] > 128) {
    // try {
    // String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[i],
    // defaultFormat);
    // if (_t != null) {
    // pybf.append(_t[0].charAt(0));
    // }
    // } catch (BadHanyuPinyinOutputFormatCombination e) {
    // e.printStackTrace();
    // }
    // } else {
    // pybf.append(arr[i]);
    // }
    // }
    // return pybf.toString().toLowerCase().trim();
    // }
    //
    // /**
    // * ��ȡ���ִ�ƴ����Ӣ���ַ�����
    // *
    // * @param chinese ���ִ�
    // * @return ����ƴ��
    // */
    // public static String getChsPingyin(String chinese) {
    // StringBuffer pybf = new StringBuffer();
    // char[] arr = chinese.toCharArray();
    // HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
    // defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    // defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] > 128) {
    // try {
    // pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i],
    // defaultFormat)[0]);
    // } catch (BadHanyuPinyinOutputFormatCombination e) {
    // e.printStackTrace();
    // }catch(java.lang.NullPointerException e)
    // {
    // e.printStackTrace();
    // }
    // } else {
    // pybf.append(arr[i]);
    // }
    // }
    // return pybf.toString();
    // }

    public static String getUserNameWithAnonymousOpt(String name, boolean bool) {

        if (TextUtils.isEmpty(name))
            return "";
        boolean isNum = isNumeric(name);
        if (bool) {
            if (isNum) {
                return name.substring(0, 3) + "**" + " （匿名）";
            } else {
                return name.substring(0, 1) + "*" + "家长";
            }
        } else {
            if (isNum) {
                return name.substring(0, 3) + "**"
                        + name.substring(name.length() - 4, name.length());
            } else {
                return name + "家长";
            }
        }
    }

    public static final String dateFormatYMDHM = "yyyy-MM-dd HH:mm";

    /**
     * 描述：Date类型转化为String类型.
     *
     * @param date   the date
     * @param format the format
     * @return String String类型日期时间
     */
    public static String getStringByFormat(Date date, String format) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
        mSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        String strDate = null;
        try {
            strDate = mSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    public static String getNameForTopicShow(String nickname) {
        String res = "";
        if (!TextUtils.isEmpty(nickname)) {
            boolean isPhone = isMobile(nickname);
            if (isPhone) {
                res = nickname.substring(0, 3)
                        + "**"
                        + nickname.substring(nickname.length() - 4,
                        nickname.length());
            } else {
                res = nickname;
            }
        }

        return res;

    }

    public static String getNameForComment(String nickname, boolean status) {
        String res = "";
        try {
            if (!StringUtil.isEmpty(nickname)) {
                boolean isPhone = isMobile(nickname);
                if (status) {
                    if (isPhone) {
                        res = nickname.substring(0, 3) + "*****" + "（匿名）";
                    } else {
                        res = nickname.substring(0, 1) + "*家长（匿名）";
                    }
                } else {
                    if (isPhone) {
                        res = nickname.substring(0, 3)
                                + "**"
                                + nickname.substring(nickname.length() - 4,
                                nickname.length());
                    } else {
                        res = nickname;
                    }
                }
            }
        } catch (Exception e) {
        }
        return res;
    }

    public static String getStringYM(int year, int month) {
        String s = "";
        if (year > 0) {
            s = s + year + "年";
        }
        if (month > 0) {
            if ((month + "").length() == 1) {
                s = s + "0" + month + "月";
            } else {
                s = s + month + "月";
            }
        }
        return s;
    }

    public static String getStringYM2(int year, int month) {
        String s = "";
        if (year > 0) {
            s = s + year + "年";
        }
        if (month > 0) {
//            if ((month + "").length() == 1) {
//                s = s + "0" + month + "月";
//            } else {
            s = s + month + "月";
//            }
        }
        return s;
    }

    /**
     * 描述：是否只是字母和数字.
     *
     * @param str 指定的字符串
     * @return 是否只是字母和数字:是为true，否则false
     */
    public static Boolean isNumberLetter(String str) {
        Boolean isNoLetter = false;
        String expr = "^[A-Za-z0-9]+$";
        if (str.matches(expr)) {
            isNoLetter = true;
        }
        return isNoLetter;
    }

    public static String getDoubleToString(double d) {
        if (d == 0) {
            return "0.00";
        } else {
            return new DecimalFormat("0.00").format(d);
        }
    }


    public static class MaxLengthInputFilter implements InputFilter {
        int MAX_EN;
        String regEx = "[\\u4e00-\\u9fa5]"; // unicode编码，判断是否为汉字
        boolean isChinese = false;

        public MaxLengthInputFilter(int maxLength, boolean isChinese) {
            this.MAX_EN = maxLength;
            this.isChinese = isChinese;
        }

        public MaxLengthInputFilter(int maxLength) {
            this.MAX_EN = maxLength;
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            int destCount;
            int sourceCount;
            if (!isChinese) {
                destCount = dest.toString().length();
                sourceCount = source.toString().length();
            } else {
                destCount = dest.toString().length() + getChineseCount(dest.toString());
                sourceCount = source.toString().length() + getChineseCount(source.toString());
            }
            if (destCount >= MAX_EN) {
                return "";
            }
            if (destCount + sourceCount > MAX_EN) {
                return source.toString().substring(0, (sourceCount - ((destCount + sourceCount) - MAX_EN)));
            } else {
                return source;
            }
        }

        /**
         * 如果汉字占两个字符通过此方法计算字符串长度
         *
         * @param str
         * @return
         */
        private int getChineseCount(String str) {
            int count = 0;
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            while (m.find()) {
                for (int i = 0; i <= m.groupCount(); i++) {
                    count = count + 1;
                }
            }
            return str.length();
        }
    }


    public static double sub(double d1, double d2) {
        return new BigDecimal(Double.toString(d1)).subtract(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static void getDifPixelInText(Context context, TextView textView, String text, int index, int largePix, int smallPix) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(context, largePix)), 0, index, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(context, smallPix)), index, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    public static void getDifPixelInText(Context context, TextView textView, String decimal, int largePix, int smallPix, int largeColor, int smallColor) {

        SpannableString spannableString = new SpannableString(decimal);
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(context, largePix)), 0, decimal.indexOf("."), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(context, smallPix)), decimal.indexOf("."), decimal.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        textView.setText(spannableString);
    }


    /***
     * 判断email格式是否正确
     */
    public static boolean isValidEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    /**
     * 描述：是否只是数字.
     *
     * @param str 指定的字符串
     * @return 是否只是字母和数字:是为true，否则false
     */
    public static Boolean isNumber(String str) {
        Boolean isNoLetter = false;
        String expr = "^[0-9]+$";
        if (str.matches(expr)) {
            isNoLetter = true;
        }
        return isNoLetter;
    }

    /**
     * 描述：是否只是字母和中文.
     *
     * @param str 指定的字符串
     * @return 是否只是字母和数字:是为true，否则false
     */
    public static Boolean isChineseAndEnglish(String str) {
        Boolean isNoLetter = false;
        String expr = "^[a-zA-Z\u4E00-\u9FA5]+$";
        if (str.matches(expr)) {
            isNoLetter = true;
        }
        return isNoLetter;
    }

    /**
     * 通过星期字符串拿到他们对应的在一周的第几天数组
     *
     * @param weeks
     * @return
     */
    public static List<Integer> getInts(List<String> weeks) {
        List<Integer> ints = new ArrayList<Integer>();
        for (int i = 0; i < weeks.size(); i++) {
            ints.add(getInt(weeks.get(i)));
        }
        Collections.sort(ints);
        return ints;
    }

    /**
     * 根据星期返回在一周第几天
     *
     * @param week
     * @return
     */
    public static int getInt(String week) {
        if ("星期一".equals(week)) {
            return 1;
        } else if ("星期二".equals(week)) {
            return 2;
        } else if ("星期三".equals(week)) {
            return 3;
        } else if ("星期四".equals(week)) {
            return 4;
        } else if ("星期五".equals(week)) {
            return 5;
        } else if ("星期六".equals(week)) {
            return 6;
        } else if ("星期日".equals(week)) {
            return 7;
        } else {
            return 0;
        }
    }

    /**
     * 通过星期集合获得显示的字符串
     *
     * @param list
     * @return
     */
    public static String getContent(List<String> list) {
        String result = "";
        if (list != null && list.size() > 0) {
            result = "每周";
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    result = result + list.get(i);
                } else {
                    result = result + list.get(i) + "、";
                }
            }
            result = result + "该时间段重复此课程";
        }
        return result;
    }

    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) {
                // 如果不能匹配,则该字符是Emoji表情
                return true;
            }
        }
        return false;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /**
     * 传入一个集合，取得中间的数字。如果是奇数取中间的数，如果是偶数取中间的俩个的第一个数
     *
     * @param list
     * @return
     */
    public static String getMiddle(String[] list) {
        String result = "";
        if (list != null && list.length > 0) {
            int size = list.length;
            // 偶数
            if (size % 2 == 0) {
                return list[size / 2 - 1];
            }
            // 奇数
            else {
                return list[size / 2];
            }
        }
        return result;
    }

    /**
     * 传入最大值和最小值返回数组
     *
     * @param min
     * @param max
     * @return
     */
    public static String[] getStringArray(int min, int max) {
        if (min < 0 || max < 0 || max <= min) {
            return null;
        }
        int length = max - min + 1;
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            int s = min + i;
            array[i] = s + "";
        }
        return array;
    }

    /**
     * 判断某个数组是否包含某个数
     *
     * @param array
     * @param str
     * @return
     */
    public static boolean isArrayContainsStr(String[] array, String str) {
        boolean flag = false;
        for (String s : array) {
            if (s.equals(str)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 将2015-06-08转换成2015年06月08日
     *
     * @param date
     * @return
     */
    public static String getYMD(String date) {
        String result = date;
        try {
            if (date.contains("-")) {
                String[] s = date.split("-");
                if (s.length == 3) {
                    result = s[0] + "年" + s[1] + "月" + s[2] + "日";
                }
            }
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 将时间戳转换成制定日期时间格式
     *
     * @param format
     * @param timestamp
     * @return
     */
    public static String getFormatDate(String format, long timestamp) {
        String rtnText = "";
        if (timestamp > 0 && !TextUtils.isEmpty(format)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            rtnText = sdf.format(new Date(timestamp));
        }
        return rtnText;
    }

    /**
     * 将时间戳转换成2015年10月12日
     *
     * @param timestamp
     * @return
     */
    public static String getFormatDate(long timestamp) {
        return getFormatDate("yyyy年MM月dd日", timestamp);
    }

    /**
     * 获取星期几
     */
    public static String getWeekText(int week) {
        return getWeekText(week, "星期");
    }

    /**
     * 获取星期/周几
     */
    public static String getWeekText(int week, String preText) {
        String rtnText = "";
        switch (week) {
            case Calendar.MONDAY:
                rtnText = preText + "一";
                break;
            case Calendar.TUESDAY:
                rtnText = preText + "二";
                break;
            case Calendar.WEDNESDAY:
                rtnText = preText + "三";
                break;
            case Calendar.THURSDAY:
                rtnText = preText + "四";
                break;
            case Calendar.FRIDAY:
                rtnText = preText + "五";
                break;
            case Calendar.SATURDAY:
                rtnText = preText + "六";
                break;
            case Calendar.SUNDAY:
                rtnText = preText + "日";
                break;
        }
        return rtnText;
    }

    /**
     * 获取课程时间文本
     * 3月2日 星期三 10:00-12:00
     * 今天显示今天
     * 昨天显示昨天
     * 明天显示明天
     * 否则显示 x月x日
     * 跨年显示年月日
     */
    public static String getCourseTimeText(long beginTime, long endTime, long serverTime) {
        String rtnText = "";
        if (beginTime > 0 && endTime > 0) {
            if (serverTime == 0) {
                serverTime = System.currentTimeMillis();
            }
            Calendar beginCalendar = Calendar.getInstance();
            beginCalendar.setTimeInMillis(beginTime);
            Calendar serverCalendar = Calendar.getInstance();
            serverCalendar.setTimeInMillis(serverTime);
            if (beginCalendar.get(Calendar.YEAR) != serverCalendar.get(Calendar.YEAR)) {
                rtnText = getFormatDate("yyyy年MM月dd日", beginTime);
            } else {
                int beginDay = beginCalendar.get(Calendar.DAY_OF_YEAR);
                int serverDay = serverCalendar.get(Calendar.DAY_OF_YEAR);
                if (beginDay == serverDay) {
                    rtnText = "今天";
                } else if (beginDay - serverDay == 1) {
                    rtnText = "明天";
                } else if (serverDay - beginDay == 1) {
                    rtnText = "昨天";
                } else {
                    rtnText = getFormatDate("MM月dd日", beginTime);
                }
            }
            if (!TextUtils.isEmpty(rtnText)) {
                if (beginCalendar.get(Calendar.YEAR) == serverCalendar.get(Calendar.YEAR)) {
                    rtnText += " " + getWeekText(beginCalendar.get(Calendar.DAY_OF_WEEK), "周");
                }
                rtnText += " " + getFormatDate("HH:mm", beginTime) + "-" + getFormatDate("HH:mm", endTime);
            }
        }
        return rtnText;
    }

    /**
     * 获取动态发布时间
     * 小于一分钟显示  刚刚
     * 大于等于一分钟小于一小时显示  XX分钟前
     * 大于等于一小时小于一天显示  XX小时前
     * 大于等于一天小于48小时显示  昨天
     * 大于等于48小时显示  X月X日
     * 大于一年显示  X年X月X日
     */
    public static String getDynamicPostTime(long timestamp) {
        String rtnText = "";
        long currentTimestamp = System.currentTimeMillis();
        String year = getFormatDate("yyyy", timestamp);
        String currentYear = getFormatDate("yyyy", currentTimestamp);
        if (!TextUtils.isEmpty(year) && !TextUtils.isEmpty(currentYear) && !year.equals(currentYear)) {
            rtnText = getFormatDate(timestamp);
        } else {
            //间隔秒数
            long delta = (currentTimestamp - timestamp) / 1000;
            if (delta >= 0 && delta < 60) {
                rtnText = "刚刚";
            } else if (delta >= 60 && delta < 60 * 60) {
                int minuteNumber = (int) (delta / 60);
                rtnText = minuteNumber + "分钟前";
            } else if (delta >= 60 * 60 && delta < 24 * 60 * 60) {
                int hourNumber = (int) (delta / 60 / 60);
                rtnText = hourNumber + "小时前";
            } else if (delta >= 24 * 60 * 60 && delta < 48 * 60 * 60) {
                rtnText = "昨天";
            } else if (delta >= 48 * 60 * 60 && delta < 365 * 24 * 60 * 60) {
                rtnText = getFormatDate("MM月dd日", timestamp);
            } else {
                rtnText = getFormatDate(timestamp);
            }
        }
//        String rtnText = getFormatDate(timestamp);
//        String currentDate = getFormatDate(System.currentTimeMillis());
//        String prevDate = getFormatDate(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
//        if (currentDate.equals(rtnText)) {
//            rtnText = "今天";
//        }
//        if (prevDate.equals(rtnText)) {
//            rtnText = "昨天";
//        }
        return rtnText;
    }

    /**
     * 获取动态话题计数文本
     */
    public static String getDynamicTopicCountText(long count) {
        if (count < 0) {
            count = 0;
        }
        String rtnText = count + "";
        if (count > 9999) {
            double num = (count / 1000) * 1.0d / 10;
            rtnText = getDoubleToStringWithOneDot(num) + "万";
        }
        return rtnText;
    }

    /**
     * 增加动态话题的标识符
     */
    public static String addDynamicTopicSeparator(String topicText, boolean isBoth) {
        String rtnText = "#" + topicText;
        if (isBoth) {
            rtnText += "#";
        }
        return rtnText;
    }


    public static String getDoubleToStringWithOneDot(double d) {
        if (d == 0) {
            return "0.0";
        } else {
            return new DecimalFormat("#0.0").format(d);
        }
    }

    public static String getDoubleToStringWithOneDotAbandon(double d) {
        try {
            int intnumber = (int) d;
            if (intnumber == d) {
                return intnumber + "";
            } else if (d == 0) {
                return "0";
            } else {
                String str = new DecimalFormat("#.##############").format(d);
                String tempStr;
                String tempStr2 = str.split("\\.")[1];
                tempStr = str.split("\\.")[0] + "."
                        + tempStr2.substring(0, 1);
                return tempStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDoubleToStringWithTwoDot(double d) {
        try {
            int intnumber = (int) d;
            if (intnumber == d) {
                return intnumber + ".00";
            } else if (d == 0) {
                return "0.00";
            } else {
                String str = new DecimalFormat("#.##############").format(d);
                String tempStr;
                String tempStr2 = str.split("\\.")[1];
                if (tempStr2.length() < 2) {
                    tempStr = str + "0";
                } else {
                    tempStr = str.split("\\.")[0] + "."
                            + tempStr2.substring(0, 2);
                }
                return tempStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseSmsCheckCode(String str) {
        String checkCode = "";
        Pattern pattern = Pattern.compile("[0-9]{6}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            if (matcher.groupCount() > 1) {
                checkCode = matcher.group(0);
            } else {
                checkCode = matcher.group();
            }
        }
        return checkCode;
    }

    public static int parseToInt(String str) {
        if (isNumber(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    /**
     * 获取text的整数部分
     */
    public static String getIntegerTextFromText(String d) {
        String rtnText = d + "";
        int pos = rtnText.indexOf(".");
        if (pos > -1) {
            rtnText = rtnText.substring(0, pos);
        }
        return rtnText;
    }

    /**
     * 获取text的小数部分
     */
    public static String getDecimalTextFromText(String d) {
        String rtnText = "";
        String dText = d + "";
        int pos = dText.indexOf(".");
        if (pos > -1) {
            rtnText = dText.substring(pos + 1);
        }
        int length = rtnText.length();
        if (length == 0) {
            rtnText = "00";
        } else if (length == 1) {
            rtnText += "0";
        } else if (length > 2) {
            rtnText = rtnText.substring(0, 2);
        }
        return rtnText;
    }

    /**
     * 获取text的小数部分,保留一位小数点
     */
    public static String getDecimalTextFromText1(String d) {
        String rtnText = "";
        String dText = d + "";
        int pos = dText.indexOf(".");
        if (pos > -1) {
            rtnText = dText.substring(pos + 1);
        }
        if (rtnText.length() > 1) {
            return rtnText.substring(0, 1);
        }
        return rtnText;
    }

    public static String getDecimalTextFromText2(String d) {
        String text = d;
        if (!StringUtil.isEmpty(d) && d.contains(".0")) {
            d = d.replace(".0", "ccm");
            String[] ss = d.split("ccm");
            if (ss != null && ss.length == 1) {
                text = ss[0];
            }
        }
        return text;
    }

    public static Date stringToDate(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(time, pos);
        return date;
    }

    public static String dateToString(Date time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        String ctime = formatter.format(time);
        return ctime;
    }

    public static String convertTime(String time) {
        String convert = "";
        Date date = stringToDate(time);
        if (date != null) {
            convert = dateToString(date);
            if (convert != null) {
                return convert.substring(convert.indexOf("年") + 1);
            }
        }
        return convert;
    }



    public static void getDifPixelInAndStrikethrough(Context context, TextView textView, String text, int index, int largePix, int smallPix) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(context, largePix)), 0, index, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayUtils.sp2px(context, smallPix)), index, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StrikethroughSpan(), 0, text.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    /**
     * @param context       上下文
     * @param tv_price      textview
     * @param bigSizeText   大字体的那些字符串
     * @param bigSize       大字体的大小
     * @param smallSizeText 小字体的那些字符串
     * @param smallSize     小字体的大小
     * @param top           textview的底部距离父控件顶部的距离
     * @param line          线控件
     */
    public static void layoutLine(Context context, TextView tv_price, String bigSizeText, int bigSize, String smallSizeText, int smallSize, int top, View line) {
        TextPaint textPaint = tv_price.getPaint();
        textPaint.setTextSize(DisplayUtils.sp2px(context, bigSize));
        int bigSizeTextWidth = (int) (textPaint.measureText(bigSizeText));
        Paint.FontMetrics fm = textPaint.getFontMetrics();
        int textViewHalfHeight = (int) (Math.ceil(fm.descent - fm.top) / 2);

        textPaint.setTextSize(DisplayUtils.sp2px(context, smallSize));
        float smallSizeTextWidth = textPaint.measureText(smallSizeText);
        int width = (int) (bigSizeTextWidth + smallSizeTextWidth);

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) line.getLayoutParams();
        lp.width = width;
        lp.topMargin = DisplayUtils.dip2px(context, top) - textViewHalfHeight;
        line.setLayoutParams(lp);
        line.setVisibility(View.VISIBLE);
    }

    /**
     * @param parent         RelativeLayout 父空间
     * @param lineHeightSize 线高度
     * @param lineColor      线颜色
     */
    public static void addCenterLine(Context mContext, RelativeLayout parent, int lineHeightSize, int lineColor) {
        LogUtils.d("--->", "w:" + parent.getWidth() + "H" + parent.getHeight());
        LinearLayout lineView = new LinearLayout(mContext);
        LinearLayout.LayoutParams parentPar = new LinearLayout.LayoutParams(parent.getWidth(), parent.getHeight());
        parentPar.gravity = Gravity.CENTER_VERTICAL;
        lineView.setLayoutParams(parentPar);
        TextView tv = new TextView(mContext);
        LinearLayout.LayoutParams pa = new LinearLayout.LayoutParams(parent.getWidth(), lineHeightSize);
        pa.gravity = Gravity.CENTER_VERTICAL;
        tv.setLayoutParams(pa);
        lineView.addView(tv);
        tv.setBackgroundColor(mContext.getResources().getColor(lineColor));
        parent.addView(lineView);
    }

}
