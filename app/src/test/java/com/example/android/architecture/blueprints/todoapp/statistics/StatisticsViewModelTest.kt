package com.example.android.architecture.blueprints.todoapp.statistics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.architecture.blueprints.todoapp.MainCoroutineRule
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTestRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
class StatisticsViewModelTest{

    @get:Rule
    val instanceTaskExecutorRule=InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule=MainCoroutineRule()


    //Subject under test
    private lateinit var statisticsViewModel: StatisticsViewModel

    // Use a fake repository to be injected into the view model.
    private lateinit var tasksRepository: FakeTestRepository


    //Create a @Before method that sets up the subject under test and dependencies.

    @Before
    fun setupStatisticsViewModel(){
        // Initialize the repository with no tasks.
        tasksRepository= FakeTestRepository()

        statisticsViewModel=StatisticsViewModel(tasksRepository)
    }




}