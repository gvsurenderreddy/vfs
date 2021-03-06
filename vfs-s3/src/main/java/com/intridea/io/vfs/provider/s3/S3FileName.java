/*
 * Copyright 2007 Matthias L. Jugel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intridea.io.vfs.provider.s3;

import org.apache.commons.vfs2.FileType;
import org.apache.commons.vfs2.provider.UriParser;
import org.apache.commons.vfs2.provider.url.UrlFileName;

public class S3FileName extends UrlFileName {
	protected S3FileName(final String scheme, final String path, final FileType type) {
		super(scheme, "s3.amazon.com", 0, 0, null, null,  path, type, null);
	}

	public String getBucket() {
		StringBuilder bui = new StringBuilder(getPath());
		return UriParser.extractFirstElement(bui);
	}
	
	public String getPathAfterBucket() {
		StringBuilder bui = new StringBuilder(getPath());
		UriParser.extractFirstElement(bui);
		return bui.toString();
	}
}
