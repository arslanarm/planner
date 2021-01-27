package me.plony.planner.platform

import kotlinx.coroutines.GlobalScope
import kotlin.coroutines.CoroutineContext

public actual fun coroutineContextForPlanner(): CoroutineContext = GlobalScope.coroutineContext