package com.example.android.architecture.blueprints.todoapp.taskdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTestRepository
import org.junit.Before
import org.junit.Rule

class TaskDetailViewModelTest{
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var taskDetailViewModel: TaskDetailViewModel

    // Use a fake repository to be injected into the viewmodel
    private lateinit var testRepository: FakeTestRepository

    // Rest of class


    @Before
    fun setupViewModel() {
        testRepository = FakeTestRepository()
        val task1 = Task("Title1", "Description1")
        val task2 = Task("Title2", "Description2", true)
        val task3 = Task("Title3", "Description3", true)

        testRepository.addTasks(task1,task2,task3)

        //GIVEN a fresh ViewModel
        taskDetailViewModel = TaskDetailViewModel(testRepository)
    }

  //Here we can add tests for testing TaskDetailViewModel
}