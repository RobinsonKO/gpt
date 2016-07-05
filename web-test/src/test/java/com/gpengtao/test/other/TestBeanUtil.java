package com.gpengtao.test.other;

import com.google.common.collect.Lists;
import com.gpengtao.model.Book;
import com.gpengtao.model.GenderType;
import com.gpengtao.model.User;
import com.gpengtao.web.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by gpengtao on 15/4/21.
 */
public class TestBeanUtil {

    @Test
    public void test_ben_util() {
        User user = new User();
        user.setName("gpengtao");
        user.setPassword("123456");
        user.setAge(28);
        user.setGender(GenderType.M);

        List<Book> books = Lists.newArrayList(new Book(), new Book("java2"), new Book("java3", BigDecimal.ONE));
        user.setBooks(books);

        System.out.println(user);

        UserVo userVO = new UserVo();

        BeanUtils.copyProperties(user, userVO, new String[]{"password"});

        System.out.println(userVO);
    }
}
