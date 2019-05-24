package com.dicoding.academies.ui.reader;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.academies.data.source.AcademyRepository;
import com.dicoding.academies.data.source.local.entity.ContentEntity;
import com.dicoding.academies.data.source.local.entity.ModuleEntity;
import com.dicoding.academies.utils.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class CourseReaderViewModel extends ViewModel {

    private String courseId;
    private String moduleId;
    private AcademyRepository academyRepository;

    public CourseReaderViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public LiveData<List<ModuleEntity>> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LiveData<ModuleEntity> getSelectedModule() {
        return academyRepository.getContent(courseId, moduleId);
    }

    public void setSelectedModule(String moduleId) {
        this.moduleId = moduleId;
    }
}
