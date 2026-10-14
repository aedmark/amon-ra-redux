;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 921)
(include sci.sh)
(use Main)
(use Interface)
(use Dialog)
(use System)

(public
	Prints 0
	Printf 1
	GetInput 2
)

(procedure (Prints)
	(Print addText: &rest init:)
)

(procedure (Printf)
	(Print addTextF: &rest init:)
)

(procedure (GetInput str maxLen prompt theFont)
	(if
		(Print
			font: (if (> argc 3) theFont else 0)
			addText: (if (and (> argc 2) prompt) prompt else {})
			addEdit: str maxLen 0 12 str
			init:
		)
		(StrLen str)
	)
)

(class Print of Obj
	(properties
		name {Print}
		dialog 0
		window 0
		title 0
		mode 0
		font 0
		width 0
		x -1
		y -1
		ticks 0
		caller 0
		retValue 0
		modeless 0
		first 0
		saveCursor 0
	)

	(method (init param1)
		(= caller 0)
		(if argc
			(= caller param1)
		)
		(if (> argc 1)
			(self addText: &rest)
		)
		(if (not modeless)
			(if (not (IsObject gPrints))
				(= gPrints ((EventHandler new:) name: {prints}))
			)
			(gPrints add: self)
		)
		(self showSelf:)
	)

	(method (doit)
		(dialog eachElementDo: 57)
	)

	(method (dispose)
		(if (and gPrints (gPrints contains: self))
			(gPrints delete: self)
			(if (gPrints isEmpty:)
				(gPrints dispose:)
				(= gPrints 0)
			)
		)
		(= title (= first (= saveCursor (= window 0))))
		(= font gUserFont)
		(= width (= mode 0))
		(= x (= y -1))
		(= modeless 0)
		(gSounds pause: 0)
		(super dispose:)
	)

	(method (showSelf &tmp temp0 temp1 temp2 temp3 temp4)
		(if saveCursor
			(gGame setCursor: 999)
		)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(dialog
			window: (if window window else gSystemWindow)
			name: {PODialog}
			caller: self
		)
		(dialog text: title time: ticks setSize:)
		(dialog center:)
		(= temp3
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp4
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp3 temp4)
		(= temp1 (GetPort))
		(dialog open: (if title 4 else 0) 15)
		(if modeless
			(= gModelessPort (GetPort))
			(SetPort temp1)
			(= gModelessDialog dialog)
		else
			(gSounds pause: 1)
			(cond
				((not (= temp0 first))
					(if
						(and
							(= temp0 (dialog firstTrue: 185 1))
							(not (dialog firstTrue: 185 2))
						)
						(temp0 state: (| (temp0 state:) $0002))
					)
				)
				((not (IsObject temp0))
					(= temp0 (dialog at: temp0))
				)
			)
			(= retValue (dialog doit: temp0))
			(SetPort temp1)
			(cond
				((== retValue -1)
					(= retValue 0)
				)
				((and (IsObject retValue) (retValue isKindOf: DButton))
					(= retValue (retValue value:))
				)
				((not (dialog theItem:))
					(= retValue 1)
				)
			)
			(if saveCursor
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(dialog dispose:)
			(return retValue)
		)
	)

	(method (addButton param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (> argc 4)
			(= temp0 param2)
			(= temp1 param3)
			(= temp2 param4)
			(= temp3 (if param5 param5 else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (> argc 5)
				(= temp4 param6)
				(if (> argc 6)
					(= temp5 param7)
					(if (> argc 7)
						(= temp6 param8)
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (not (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7))
					(= temp7 0)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (> argc 2)
				(= temp4 param3)
				(if (> argc 3)
					(= temp5 param4)
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen param2) 1)))
			(StrCpy temp7 param2)
		)
		(if temp7
			(dialog
				add:
					((DButton new:)
						value: param1
						font: font
						text: temp7
						setSize:
						moveTo: (+ 4 temp4) (+ 4 temp5)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (addEdit param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(StrCpy param1 (if (> argc 4) param5 else {}))
		(if (> argc 2)
			(= temp0 param3)
			(if (> argc 3)
				(= temp1 param4)
			)
		)
		(dialog
			add:
				((DEdit new:)
					text: param1
					max: param2
					setSize:
					moveTo: (+ temp0 4) (+ temp1 4)
					yourself:
				)
			setSize:
		)
	)

	(method (addIcon param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (> argc 3)
			(= temp0 param4)
			(= temp1 param5)
		else
			(= temp0 (= temp1 0))
		)
		(if (IsObject param1)
			(dialog
				add:
					(param1 setSize: moveTo: (+ temp0 4) (+ temp1 4) yourself:)
				setSize:
			)
		else
			(dialog
				add:
					((DIcon new:)
						view: param1
						loop: param2
						cel: param3
						setSize:
						moveTo: (+ temp0 4) (+ temp1 4)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (addText param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (> argc 3)
			(= temp0 param1)
			(= temp1 param2)
			(= temp2 param3)
			(= temp3 (if param4 param4 else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (>= argc 5)
				(= temp4 param5)
				(if (>= argc 6)
					(= temp5 param6)
					(if (>= argc 7)
						(= temp6 param7)
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7)
					(dialog
						add:
							((DText new:)
								text: temp7
								font: font
								mode: mode
								setSize: width
								moveTo: (+ 4 temp4) (+ 4 temp5)
								yourself:
							)
						setSize:
					)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (>= argc 2)
				(= temp4 param2)
				(if (>= argc 3)
					(= temp5 param3)
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen param1) 1)))
			(StrCpy temp7 param1)
			(dialog
				add:
					((DText new:)
						text: temp7
						font: font
						mode: mode
						setSize: width
						moveTo: (+ 4 temp4) (+ 4 temp5)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (addTextF param1)
		(Format param1 &rest)
		(self addText: param1)
	)

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
	)

	(method (handleEvent param1)
		(if (dialog handleEvent: param1)
			(dialog dispose:)
		)
	)

	(method (cue &tmp temp0)
		(= temp0 caller)
		(= dialog 0)
		(if window
			(window dispose:)
		)
		(self dispose:)
		(if temp0
			(temp0 cue:)
		)
	)
)
