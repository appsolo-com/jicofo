/*
 * Jicofo, the Jitsi Conference Focus.
 *
 * Copyright @ 2020 - present 8x8, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.jicofo

import org.jitsi.utils.concurrent.CustomizableThreadFactory
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

class TaskPools {
    companion object {
        @JvmStatic
        val ioPool: ExecutorService =
            Executors.newCachedThreadPool(CustomizableThreadFactory("Jicofo Global IO Pool", false))

        @JvmStatic
        val scheduledPool: ScheduledExecutorService = Executors.newScheduledThreadPool(
            3, CustomizableThreadFactory("Jicofo Global Scheduled Pool", true)
        )

        @JvmStatic
        fun shutdown() {
            ioPool.shutdown()
            scheduledPool.shutdown()
        }
    }
}
