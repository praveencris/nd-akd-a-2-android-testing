package com.example.android.architecture.blueprints.todoapp.taskdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTasksRepository
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import com.example.android.architecture.blueprints.todoapp.tasks.TasksFilterType
import com.example.android.architecture.blueprints.todoapp.tasks.TasksViewModel
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TaskDetailViewModelTest{
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var taskDetailViewModel: TaskDetailViewModel

    // Use a fake repository to be injected into the viewmodel
    private lateinit var tasksRepository: FakeTasksRepository

    // Rest of class


    @Before
    fun setupViewModel() {
        tasksRepository = FakeTasksRepository()
        val task1 = Task("Title1", "Description1")
        val task2 = Task("Title2", "Description2", true)
        val task3 = Task("Title3", "Description3", true)

        tasksRepository.addTasks(task1,task2,task3)

        //GIVEN a fresh ViewModel
        taskDetailViewModel = TaskDetailViewModel(tasksRepository)
    }

  //Here we can add tests for testing TaskDetailViewModel
}