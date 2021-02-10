package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Test

import org.junit.Assert.*

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returns_HundredZero() {
        val task = listOf<Task>(
                Task("Title", "Description", isCompleted = false),
                Task("Title", "Description", isCompleted = false),
                Task("Title", "Description", isCompleted = false),
        )
        val stats = getActiveAndCompletedStats(task)
        assertEquals(100f, stats.activeTasksPercent)
        assertEquals(0f, stats.completedTasksPercent)
    }


    @Test
    fun getActiveAndCompletedStats_someCompleted_returns_SixtyForty() {
        val task = listOf<Task>(
                Task("Title", "Description", isCompleted = true),
                Task("Title", "Description", isCompleted = true),
                Task("Title", "Description", isCompleted = false),
                Task("Title", "Description", isCompleted = false),
                Task("Title", "Description", isCompleted = false)
        )
        val stats = getActiveAndCompletedStats(task)
        assertEquals(60f, stats.activeTasksPercent)
        assertEquals(40f, stats.completedTasksPercent)
    }


    @Test
    fun getActiveAndCompletedStats_empty_returns_Zero() {
        val task = emptyList<Task>()
        val stats = getActiveAndCompletedStats(task)
        assertEquals(0f, stats.activeTasksPercent)
        assertEquals(0f, stats.completedTasksPercent)
    }


    @Test
    fun getActiveAndCompletedStats_null_returns_Zero() {
        val task = null
        val stats = getActiveAndCompletedStats(task)
        assertEquals(0f, stats.activeTasksPercent)
        assertEquals(0f, stats.completedTasksPercent)
    }
}