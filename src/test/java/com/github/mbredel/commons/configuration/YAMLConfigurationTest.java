/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * The names of the contributors may not be used to endorse or promote
 *  products derived from this software without specific prior written
 * permission.
 */

package com.github.mbredel.commons.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Bredel.
 */
public class YAMLConfigurationTest {
    /** Constant for the used encoding.*/
    static final String ENCODING = "ISO-8859-1";

    /** Constant for the number of test threads. */
    private static final int THREAD_COUNT = 5;

    /** Constant for the number of loops in tests with multiple threads. */
    private static final int LOOP_COUNT = 100;

    /** The files that we test with. */
    private String testYaml = ConfigurationAssert.getTestFile("test.yaml").getAbsolutePath();
    private File testSaveConf = ConfigurationAssert.getOutFile("testsave.yaml");

    private YAMLConfiguration yamlConfiguration;

    @Before
    public void setUp() throws Exception
    {
        yamlConfiguration = new YAMLConfiguration();
        yamlConfiguration.setFile(new File(testYaml));
        yamlConfiguration.load();
        removeTestFile();
    }

    @Test
    public void testGetProperty()
    {
        assertEquals("value1", yamlConfiguration.getProperty("key1"));
        assertEquals("value23", yamlConfiguration.getProperty("key2.key3"));
    }

    @Test
    public void testSave() {
        try {
            yamlConfiguration.save(new StringWriter());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes the test output file if it exists.
     */
    private void removeTestFile()
    {
        if (testSaveConf.exists())
        {
            assertTrue(testSaveConf.delete());
        }
    }
}
