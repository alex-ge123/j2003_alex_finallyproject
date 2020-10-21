package com.qianfeng.j2003.vo;

import com.qianfeng.j2003.pojo.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeaSubCouVo {
    private Teacher teacher;
    private List<CourseVo> courseVos;
    private SubjectVo subjectVo;
}
