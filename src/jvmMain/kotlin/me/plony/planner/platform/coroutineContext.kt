package me.plony.planner.platform

import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

public actual fun coroutineContextForPlanner(): CoroutineContext = Executors.newSingleThreadExecutor().asCoroutineDispatcher()