package com.gpengtao.utils.test;

import com.gpengtao.utils.DateUtil;
import com.gpengtao.utils.ModelGenerateUtil;
import com.gpengtao.utils.MyUtil;
import com.gpengtao.utils.model.PriceModel;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pengtao.geng on 2016/10/19.
 */
public class UtilTest {

    @Test
    public void date_util_test() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date small = format.parse("2016-10-19 10:01:01");
        Date big = format.parse("2016-11-20 11:11:11");

        System.out.println(DateUtil.diffTimeDesc(small, big));
    }

    @Test
    public void model_generate_util_test() throws Exception {
        PriceModel model = ModelGenerateUtil.generateModel(PriceModel.class);

        System.out.println(model);
    }

    @Test
    public void my_util_test() throws Exception {
        PriceModel model = ModelGenerateUtil.generateModel(PriceModel.class);

        String result = MyUtil.joinFieldValuesWithTab(model);

        System.out.println(result);
    }
}
