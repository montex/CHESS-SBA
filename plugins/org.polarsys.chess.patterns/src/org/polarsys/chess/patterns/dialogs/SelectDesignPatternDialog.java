package org.polarsys.chess.patterns.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;
import org.polarsys.chess.patterns.utils.PatternUtils;

public class SelectDesignPatternDialog extends TitleAreaDialog {
	
	private Model chessModel;

	private TableViewer availablePatterns;
	
	private Pattern selectedPattern;

	private Group patternIntentGroup;
	private Group patternProblemGroup;
	private Group patternSolutionGroup;
	private Group patternConsequencesGroup;
	private Group patternImplementationGroup;
	private Group patternAssumptionsGroup;
	private Group patternGuaranteesGroup;
	
	private StyledText patternIntent;
	private StyledText patternProblem;
	private StyledText patternSolution;
	private StyledText patternConsequences;
	private StyledText patternImplementation;
	private StyledText patternAssumptions;
	private StyledText patternGuarantees;
	
	private Group patternPreviewGroup;

	private Label imageLabel;
	
	private Image patternPreview;

	public SelectDesignPatternDialog(Shell shell, Model chessModel) {
		super(shell);
		this.chessModel = chessModel;
	}
	
	@Override
	public void create() {
        setHelpAvailable(false);
        super.create();
		setTitle("Select a Design Pattern");
		setMessage("Select a design pattern from the list and click \"apply\" to apply it to the model ");
        getButton(IDialogConstants.OK_ID).setText("Apply");
	}
	
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		GridLayout gridLayout = (GridLayout) parent.getLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		parent.setLayout(gridLayout);
		
		//pattern selection
		GridData gdSelection = new GridData();
		gdSelection.widthHint = 400;
		gdSelection.heightHint = 200;
		gdSelection.grabExcessVerticalSpace = true;
		gdSelection.grabExcessHorizontalSpace = true;
		gdSelection.horizontalAlignment = GridData.FILL;
		gdSelection.verticalAlignment = GridData.FILL;
		gdSelection.horizontalSpan = 2;

		Group availablePatternsGroup = new Group(parent, SWT.BORDER);
		availablePatternsGroup.setText("Available Patterns");
		availablePatternsGroup.setLayout(new GridLayout(1, false));
		availablePatternsGroup.setLayoutData(gdSelection);
//		availablePatternsGroup.setSize(width, 300);

		availablePatterns = new TableViewer(availablePatternsGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_BOTH);
//		data.heightHint = 150;
//		data.widthHint = width;
		availablePatterns.getTable().setLayoutData(data);
		availablePatterns.setContentProvider(new ArrayContentProvider());
		availablePatterns.setLabelProvider(new PatternLabelProvider());
		availablePatterns.setInput(getAvailablePatterns(chessModel, new ArrayList<Pattern>()).toArray());
		availablePatternsGroup.pack();

		availablePatterns.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = availablePatterns.getSelection();
				if(selection instanceof StructuredSelection) {
					Object[] selected = ((StructuredSelection)selection).toArray();
					if((selected.length == 1) && (selected[0] instanceof Pattern)) {
						selectedPattern = ((Pattern)selected[0]);
						updatePatternDescription(selectedPattern);
					}
				}
			}
		});
		
		// pattern description
		GridData gdSingleHSpan = new GridData();
		gdSingleHSpan.widthHint = 400;
		gdSingleHSpan.heightHint = 200;
		gdSingleHSpan.grabExcessVerticalSpace = true;
		gdSingleHSpan.grabExcessHorizontalSpace = true;
		gdSingleHSpan.horizontalAlignment = GridData.FILL;
		gdSingleHSpan.verticalAlignment = GridData.FILL;
		
		GridData gdDoubleHSpan = new GridData();
		gdDoubleHSpan.widthHint = 400;
		gdDoubleHSpan.heightHint = 200;
		gdDoubleHSpan.grabExcessVerticalSpace = true;
		gdDoubleHSpan.grabExcessHorizontalSpace = true;
		gdDoubleHSpan.horizontalAlignment = GridData.FILL;
		gdDoubleHSpan.verticalAlignment = GridData.FILL;
		gdDoubleHSpan.horizontalSpan = 2;
		
		GridData gdDoubleHSpanPreview = new GridData();
		gdDoubleHSpanPreview.widthHint = 600;
		gdDoubleHSpanPreview.heightHint = 400;
		gdDoubleHSpanPreview.grabExcessVerticalSpace = true;
		gdDoubleHSpanPreview.grabExcessHorizontalSpace = true;
		gdDoubleHSpanPreview.horizontalAlignment = GridData.FILL;
		gdDoubleHSpanPreview.verticalAlignment = GridData.FILL;
		gdDoubleHSpanPreview.horizontalSpan = 2;
		
		GridData gdText = new GridData();
		gdText.horizontalAlignment = GridData.FILL;
		gdText.grabExcessHorizontalSpace = true;
		gdText.grabExcessVerticalSpace = true;
		gdText.heightHint = 200;
		
		//intent
		patternIntentGroup = new Group(parent, SWT.BORDER);
		patternIntentGroup.setText("Intent/Context");
		patternIntentGroup.setLayout(new GridLayout(1, false));
		patternIntentGroup.setLayoutData(gdSingleHSpan);
//		patternIntentGroup.setSize(400, 300);
		
		patternIntent = new StyledText(patternIntentGroup, SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
//		patternIntent.setAlwaysShowScrollBars(true);
		patternIntent.setLayoutData(gdText);
		
		//problem
		patternProblemGroup = new Group(parent, SWT.BORDER);
		patternProblemGroup.setText("Problem");
		patternProblemGroup.setLayout(new GridLayout(1, false));
		patternProblemGroup.setLayoutData(gdSingleHSpan);
//		patternProblemGroup.setSize(400, 300);
		
		patternProblem = new StyledText(patternProblemGroup, SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
//		patternProblem.setAlwaysShowScrollBars(false);
		patternProblem.setLayoutData(gdText);
		
		//solution
		patternSolutionGroup = new Group(parent, SWT.BORDER);
		patternSolutionGroup.setText("Solution/Pattern Structure");
		patternSolutionGroup.setLayout(new GridLayout(1, false));
		patternSolutionGroup.setLayoutData(gdDoubleHSpan);
//		patternSolutionGroup.setSize(400, 300);
		
		patternSolution = new StyledText(patternSolutionGroup, SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
//		patternSolution.setAlwaysShowScrollBars(false);
		patternSolution.setLayoutData(gdText);
		
		//consequences
		patternConsequencesGroup = new Group(parent, SWT.BORDER);
		patternConsequencesGroup.setText("Consequences");
		patternConsequencesGroup.setLayout(new GridLayout(1, false));
		patternConsequencesGroup.setLayoutData(gdSingleHSpan);
//		patternConsequencesGroup.setSize(400, 300);
		
		patternConsequences = new StyledText(patternConsequencesGroup, SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
//		patternConsequences.setAlwaysShowScrollBars(false);
		patternConsequences.setLayoutData(gdText);
		
		//implementation
		patternImplementationGroup = new Group(parent, SWT.BORDER);
		patternImplementationGroup.setText("Implementation");
		patternImplementationGroup.setLayout(new GridLayout(1, false));
		patternImplementationGroup.setLayoutData(gdSingleHSpan);
//		patternImplementationGroup.setSize(400, 300);
		
		patternImplementation = new StyledText(patternImplementationGroup, SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
//		patternImplementation.setAlwaysShowScrollBars(false);
		patternImplementation.setLayoutData(gdText);
		
		//assumptions
		patternAssumptionsGroup = new Group(parent, SWT.BORDER);
		patternAssumptionsGroup.setText("Pattern Assumptions");
		patternAssumptionsGroup.setLayout(new GridLayout(1, false));
		patternAssumptionsGroup.setLayoutData(gdSingleHSpan);
//		patternAssumptionsGroup.setSize(400, 300);
		
		patternAssumptions = new StyledText(patternAssumptionsGroup, SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
//		patternAssumptions.setAlwaysShowScrollBars(false);
		patternAssumptions.setLayoutData(gdText);
		
		//guarantees
		patternGuaranteesGroup = new Group(parent, SWT.BORDER);
		patternGuaranteesGroup.setText("Pattern Guarantees");
		patternGuaranteesGroup.setLayout(new GridLayout(1, false));
		patternGuaranteesGroup.setLayoutData(gdSingleHSpan);
//		patternGuaranteesGroup.setSize(400, 300);
		
		patternGuarantees = new StyledText(patternGuaranteesGroup, SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
//		patternGuarantees.setAlwaysShowScrollBars(false);
		patternGuarantees.setLayoutData(gdText);
		
		//preview
		patternPreviewGroup = new Group(parent, SWT.BORDER);
		patternPreviewGroup.setText("Pattern Preview");
		patternPreviewGroup.setLayout(new FillLayout());
		patternPreviewGroup.setLayoutData(gdDoubleHSpanPreview);
//		patternPreviewGroup.setSize(400, 300);
		
		imageLabel = new Label(patternPreviewGroup, SWT.CENTER);
		imageLabel.setText("preview not available");
		
		return super.createDialogArea(parent);
	}

	protected void updatePatternDescription(Pattern selectedPattern) {
		patternIntent.setText(selectedPattern.getIntent() != null? selectedPattern.getIntent() : "not available");
		patternProblem.setText(selectedPattern.getProblem() != null? selectedPattern.getProblem() : "not available");
		patternSolution.setText(selectedPattern.getSolution() != null? selectedPattern.getSolution() : "not available");
		patternConsequences.setText(selectedPattern.getConsequences() != null? PatternUtils.StringListToString(selectedPattern.getConsequences()) : "not available");
		patternImplementation.setText(selectedPattern.getImplementation() != null? PatternUtils.StringListToString(selectedPattern.getImplementation()) : "not available");
		patternAssumptions.setText(selectedPattern.getPatternAssumptions() != null? PatternUtils.StringListToString(selectedPattern.getPatternAssumptions()) : "not available");
		patternGuarantees.setText(selectedPattern.getPatternGuarantees() != null? PatternUtils.StringListToString(selectedPattern.getPatternGuarantees()) : "not available");
	
		Image image = PatternUtils.retrieveImageforPatternPreview(selectedPattern);
		if(image != null){
			//resize image
			int width = imageLabel.getSize().x;
			int height = imageLabel.getSize().y;
			Image scaled = new Image(Display.getDefault(), width, height);
			GC gc = new GC(scaled);
			gc.setAntialias(SWT.ON);
			gc.setInterpolation(SWT.HIGH);
			gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 
			0, 0, width, height);
			gc.dispose();
			image.dispose();
			patternPreview = scaled;
			imageLabel.setImage(scaled);
		}else{
			imageLabel.setImage(null);
		}
	}

	private List<Pattern> getAvailablePatterns(Package pkg, List<Pattern> patternList) {
		for(Element el : pkg.getMembers()) {
			if(el instanceof Collaboration){
				Stereotype stereo = el.getAppliedStereotype("PatternsProfile::Pattern");
				if(stereo != null){
					Pattern pattern = (Pattern) el.getStereotypeApplication(stereo);
					if(pattern != null){
						patternList.add(pattern);
					}
				}
			}
			if(el instanceof Package) {
				getAvailablePatterns((Package)el, patternList);
			}
		}
		return patternList;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	public Pattern getSelectedPattern() {
		return selectedPattern;
	}

	public Image getPatternPreview() {
		return patternPreview;
	}
}
