package com.huiminpay.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huiminpay.bean.Stu;
import com.huiminpay.mapper.StuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MabytisPlusTest {

    @Resource
    private StuMapper stuMapper;

    /**
     * Lombda 模糊查询+条件查询
     */
    @Test
    public void lombdaWrapperTest() {
        LambdaQueryWrapper<Stu> wrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Stu> like =
                wrapper.like(Stu::getName, "马")
                .gt(Stu::getAge,50);
        List<Stu> stus = stuMapper.selectList(like);
        stus.forEach(System.out::println);
    }
    /**
     * Lombda 模糊查询
     */
    @Test
    public void lombdaTest() {
        LambdaQueryWrapper<Stu> wrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Stu> like = wrapper.like(Stu::getName, "马");
        List<Stu> stus = stuMapper.selectList(like);
        stus.forEach(System.out::println);
    }
    /**
     * 模糊查询
     */
    @Test
    public void likeTest() {
        QueryWrapper<Stu> wrapper = new QueryWrapper<>();
        wrapper.like("name", "马");
        List<Stu> list=stuMapper.selectList(wrapper);
        for (Stu stu : list) {
            System.out.println(stu);
        }
    }
    /**
     * 分页查询
     */
    @Test
    public void PageTest() {
        Page<Stu> page = new Page<>(1, 5);
        IPage<Stu> stuIPage = stuMapper.selectPage(page, null);
        List<Stu> stus = stuIPage.getRecords();
        for (Stu stu : stus) {
            System.out.println(stu);
        }
        System.out.println(stuIPage);
    }
    /**
     * 查询集合
     */
    @Test
    public void queryListTest() {
        List<Stu> list = stuMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        for (Stu stu : list) {
            System.out.println(stu);
        }
    }
    /**
     * 查询单个数据
     */
    @Test
    public void queryStuByIdTest() {
        Stu stu = stuMapper.selectById(1);
        System.out.println("单个数据："+stu);
    }

    /**
     * 插入数据
     */
    @Test
    public void inserTest() {
        Stu stu = new Stu();
        stu.setName("张三");
        stu.setId(116);
        int insert = stuMapper.insert(stu);
        System.out.println("添加的结果"+insert);
        System.out.println("stu"+stu);
    }

}
