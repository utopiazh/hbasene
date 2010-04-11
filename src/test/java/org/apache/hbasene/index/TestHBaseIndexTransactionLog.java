/**
 * Copyright 2010 Karthik Kumar
 * 
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hbasene.index;

import java.io.IOException;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.store.LockObtainFailedException;
import org.junit.Test;

public class TestHBaseIndexTransactionLog extends AbstractHBaseneTest {

  @SuppressWarnings("unused")
  private static final Logger LOGGER = Logger
      .getLogger(TestHBaseIndexTransactionLog.class.getName());

  @Test
  public void testAddDocuments() throws CorruptIndexException,
      LockObtainFailedException, IOException {

    assertDocumentPresent("FactTimes");
    assertDocumentPresent("UtopiaTimes");

    listLongRows(HBaseIndexTransactionLog.FAMILY_INT_TO_DOC);
    listLongQualifiers(HBaseIndexTransactionLog.FAMILY_DOC_TO_INT);
    listTermVectors();
    listAll(HBaseIndexTransactionLog.FAMILY_DOCUMENTS);
    listAll(HBaseIndexTransactionLog.FAMILY_SEQUENCE);
    /**
     * TODO: For some reason the documentId does not appear in the term vector. Need to examine..
    assertTermVectorDocumentMapping("content/messi", Bytes.toBytes(1L));
    assertTermVectorDocumentMapping("content/lionel", Bytes.toBytes(2L));
    **/
  }

}
