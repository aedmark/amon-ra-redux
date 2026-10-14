;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 978)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)

(class GameControls of IconBar
	(properties
		name {GameControls}
		height 200
		state 0
		okButton 0
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: 167))
			(gPMouse stop:)
		)
		(|= state $0020)
		(if (IsObject window)
			(window open:)
		else
			(= window
				((gSystemWindow new:)
					top: 46
					left: 24
					bottom: 155
					right: 296
					priority: 15
					open:
					yourself:
				)
			)
		)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 temp3))
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
			(if (and (not (& (temp4 signal:) $0080)) (<= (temp4 nsRight:) 0))
				(temp4 show: temp0 temp1)
				(= temp0 (+ 20 (temp4 nsRight:)))
			else
				(temp4 show:)
			)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(if curIcon
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(curIcon nsLeft:)
						(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
					)
					(- (curIcon nsBottom:) 3)
			)
		)
		(self doit: hide:)
	)

	(method (hide)
		(if window
			(window dispose:)
			(= window 0)
		)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
	)

	(method (select param1 param2)
		(param1 select: (if (>= argc 2) param2 else 0))
	)

	(method (swapCurIcon))

	(method (advanceCurIcon &tmp temp0))

	(method (dispatchEvent param1 &tmp temp0 temp1 temp2 [temp3 50])
		(cond
			((== (param1 type:) 8192)
				(= temp1 (self firstTrue: 218 param1))
				(param1 dispose:)
				(if (and temp1 (temp1 helpVerb:))
					(= temp2 (GetPort))
					(if (gSystemWindow respondsTo: 236)
						(= temp0 (gSystemWindow eraseOnly:))
						(gSystemWindow eraseOnly: 1)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp1 noun:)
								(temp1 helpVerb:)
								0
								1
								0
								0
								(temp1 modNum:)
							init:
						)
						(gSystemWindow eraseOnly: temp0)
					else
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp1 noun:)
								(temp1 helpVerb:)
								0
								1
								0
								0
								(temp1 modNum:)
							init:
						)
					)
					(SetPort temp2)
				)
				(if helpIconItem
					(helpIconItem signal: (& (helpIconItem signal:) $ffef))
				)
				(gGame setCursor: 999)
				(return 0)
			)
			((& (param1 type:) $0040)
				(switch (param1 message:)
					(5
						(param1 dispose:)
						(cond
							((and (IsObject highlightedIcon) (highlightedIcon respondsTo: 191))
								(highlightedIcon retreat:)
								(return 0)
							)
							(
								(or
									(not (IsObject highlightedIcon))
									(& (highlightedIcon signal:) $0100)
								)
								(self advance:)
								(return 0)
							)
						)
					)
					(1
						(param1 dispose:)
						(cond
							((and (IsObject highlightedIcon) (highlightedIcon respondsTo: 190))
								(highlightedIcon advance:)
								(return 0)
							)
							(
								(or
									(not (IsObject highlightedIcon))
									(& (highlightedIcon signal:) $0100)
								)
								(self retreat:)
								(return 0)
							)
						)
					)
					(else
						(super dispatchEvent: param1)
					)
				)
			)
			(else
				(super dispatchEvent: param1)
			)
		)
	)
)

(class ControlIcon of IconI
	(properties
		name {ControlIcon}
		theObj 0
		selector 0
	)

	(method (doit)
		(if theObj
			(if (& signal $0040)
				((if gGameControls gGameControls else GameControls) hide:)
			)
			(gGame panelObj: theObj panelSelector: selector)
		)
	)
)
