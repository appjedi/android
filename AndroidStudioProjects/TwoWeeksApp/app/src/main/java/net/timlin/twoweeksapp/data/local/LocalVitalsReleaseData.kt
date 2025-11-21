/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.timlin.twoweeksapp.data.local

import net.timlin.twoweeksapp.R
import net.timlin.twoweeksapp.model.DayTip
/**
 * [Datasource] generates a list of [DayTip]
 */
object DataSource {
    val dayTips = listOf(
            DayTip(R.string.day1, R.drawable.day1, R.string.tip1),
            DayTip(R.string.day2, R.drawable.day2,R.string.tip2),
            DayTip(R.string.day3, R.drawable.day3,R.string.tip3),
            DayTip(R.string.day4, R.drawable.day4,R.string.tip4),
            DayTip(R.string.day5, R.drawable.day5,R.string.tip5),
            DayTip(R.string.day6, R.drawable.day6,R.string.tip6),
            DayTip(R.string.day7, R.drawable.day7,R.string.tip7),
            DayTip(R.string.day8, R.drawable.day8,R.string.tip8),
            DayTip(R.string.day9, R.drawable.day9,R.string.tip9),
            DayTip(R.string.day10, R.drawable.day10,R.string.tip10),
            DayTip(R.string.day11, R.drawable.day11,R.string.tip11),
            DayTip(R.string.day12, R.drawable.day12,R.string.tip12),
            DayTip(R.string.day13, R.drawable.day13,R.string.tip13),
            DayTip(R.string.day14, R.drawable.day14,R.string.tip14))

}
