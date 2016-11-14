package com.example.sureshreddy.barclays;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sureshreddy.barclays.common.StringUtil;


@RunWith(MockitoJUnitRunner.class)
public class StringTest {

    private static final String REQ_STRING = "Sam_smith";

    @Mock
    Context mMockContext;
    @Test
    public void enteredStringTest() {

        StringUtil stringUtil=new StringUtil();
        String result= stringUtil.getValidString("Sam smith");
        assertThat (result, is(REQ_STRING));
    }
    }

