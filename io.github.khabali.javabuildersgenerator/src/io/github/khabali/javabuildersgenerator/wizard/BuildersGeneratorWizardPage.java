/**
 * MIT License
 *
 * Copyright (c) 2017 Anas KHABALI
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.khabali.javabuildersgenerator.wizard;

import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import io.github.khabali.javabuildersgenerator.Field;

public class BuildersGeneratorWizardPage extends WizardPage {
	private Composite container;

	private final List<Field> fields;

	private org.eclipse.swt.widgets.List list;

	public BuildersGeneratorWizardPage(final List<Field> fields) {
		super("Field selection");
		setTitle("Select your mandatory fields");
		setDescription("This will generate builders for all the fields below,"
		        + "\r\nYou can select some fields to make them mandatory for the object construction");

		this.fields = fields;
	}

	@Override
	@PostConstruct
	public void createControl(final Composite parent) {
		setPageComplete(true);

		this.container = new Composite(parent, SWT.NONE);
		setControl(this.container);
		this.container.setLayout(new FillLayout(SWT.VERTICAL));

		this.list = new org.eclipse.swt.widgets.List(this.container, SWT.BORDER | SWT.MULTI);

		for (int i = 0; i < this.fields.size(); i++) {
			this.list.add(this.fields.get(i).getName());
		}
	}

	int[] getSelectedFields() {
		return this.list.getSelectionIndices();
	}

	public List<Field> getFields() {
		return this.fields;
	}

}
