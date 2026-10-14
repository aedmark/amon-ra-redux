;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class IconI of Obj
	(properties
		name {IconI}
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state 0
		cursor -1
		type 16384
		message -1
		modifiers 0
		signal 1
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
	)

	(method (show param1 param2 &tmp [temp0 7])
		(|= signal $0020)
		(if argc
			(= nsRight (+ (= nsLeft param1) (CelWide view loop cel)))
			(= nsBottom (+ (= nsTop param2) (CelHigh view loop cel)))
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: 167))
			(gPMouse stop:)
		)
	)

	(method (select param1 &tmp temp0 temp1)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= temp0 (Event new:)) type:) 2)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (+ nsTop 2))
		(= temp1 (+ nsLeft 2))
		(= temp2 (- nsBottom 3))
		(= temp3 (- nsRight 4))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)

	(method (onMe param1)
		(return
			(if
				(and
					(>= (param1 x:) nsLeft)
					(>= (param1 y:) nsTop)
					(<= (param1 x:) nsRight)
				)
				(<= (param1 y:) nsBottom)
			else
				0
			)
		)
	)

	(method (mask)
		(DrawCel
			maskView
			maskLoop
			maskCel
			(+
				nsLeft
				(/
					(-
						(CelWide view loop cel)
						(CelWide maskView maskLoop maskCel)
					)
					2
				)
			)
			(+
				nsTop
				(/
					(-
						(CelHigh view loop cel)
						(CelHigh maskView maskLoop maskCel)
					)
					2
				)
			)
			-1
		)
	)
)

(class IconBar of Set
	(properties
		name {IconBar}
		height 0
		underBits 0
		oldMouseX 0
		oldMouseY 0
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		curInvIcon 0
		useIconItem 0
		helpIconItem 0
		walkIconItem 0
		port 0
		window 0
		state 1024
		activateHeight 0
		y 0
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(while (and (& state $0020) (= temp0 (Event new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(Wait 1)
			(if (== temp1 256)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: temp3)
			)
			(temp0 localize:)
			(if
				(and
					(or (== temp1 1) (and (== temp1 4) (== temp2 13)))
					(IsObject helpIconItem)
					(& (helpIconItem signal:) $0010)
				)
				(temp0 type: 24576 message: (helpIconItem message:))
			)
			(MapKeyToDir temp0)
			(if (self dispatchEvent: temp0)
				(break)
			)
		)
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(param1 localize:)
		(= temp1 (param1 type:))
		(cond
			((& state $0004))
			(
				(or
					(and
						(not temp1)
						(& state $0400)
						(<= -10 (param1 y:))
						(<= (param1 y:) height)
						(<= 0 (param1 x:))
						(<= (param1 x:) 320)
						(not (= temp0 0))
					)
					(and
						(== temp1 4)
						(or
							(== (param1 message:) 27)
							(== (param1 message:) 21248)
						)
						(= temp0 1)
					)
				)
				(param1 globalize:)
				(= oldMouseX (param1 x:))
				(= oldMouseY (param1 y:))
				(= temp2 gTheCursor)
				(= temp3 curIcon)
				(= temp4 curInvIcon)
				(self show:)
				(gGame setCursor: 999)
				(if temp0
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
				(self doit:)
				(if temp0
					(gGame
						setCursor:
							(if
								(and
									(not (gUser canInput:))
									(not (gUser canControl:))
								)
								997
							else
								(curIcon cursor:)
							)
							1
							oldMouseX
							oldMouseY
					)
				else
					(gGame
						setCursor:
							(if
								(and
									(not (gUser canInput:))
									(not (gUser canControl:))
								)
								997
							else
								(curIcon cursor:)
							)
							1
							((= temp5 (Event new:)) x:)
							(Max (temp5 y:) (+ 1 height))
					)
					(temp5 dispose:)
				)
				(self hide:)
			)
			((& temp1 $0004)
				(switch (param1 message:)
					(13
						(if (IsObject curIcon)
							(param1
								type: (curIcon type:)
								message:
									(if (== curIcon useIconItem)
										(curInvIcon message:)
									else
										(curIcon message:)
									)
							)
						)
					)
					(20992
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(param1 claimed: 1)
					)
					(0
						(if (& (param1 type:) $0040)
							(self advanceCurIcon:)
							(param1 claimed: 1)
						)
					)
				)
			)
			((& temp1 $0001)
				(cond
					((& (param1 modifiers:) $0003)
						(self advanceCurIcon:)
						(param1 claimed: 1)
					)
					((& (param1 modifiers:) $0004)
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(param1 claimed: 1)
					)
					((IsObject curIcon)
						(param1
							type: (curIcon type:)
							message:
								(if (== curIcon useIconItem)
									(curInvIcon message:)
								else
									(curIcon message:)
								)
						)
					)
				)
			)
		)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gSounds pause:)
		(|= state $0020)
		(gGame setCursor: 999 1)
		(= height
			(CelHigh
				((= temp0 (self at: 0)) view:)
				(temp0 loop:)
				(temp0 cel:)
			)
		)
		(= port (GetPort))
		(SetPort -1)
		(= underBits (Graph grSAVE_BOX y 0 (+ y height) 320 1))
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= temp3 0)
		(= temp4 y)
		(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 temp6))
			(= temp6 (NextNode temp5))
			(if (not (IsObject (= temp7 (NodeValue temp5))))
				(return)
			)
			(if (<= (temp7 nsRight:) 0)
				(temp7 show: temp3 temp4)
				(= temp3 (temp7 nsRight:))
			else
				(temp7 show:)
			)
		)
		(if curInvIcon
			(if (gEgo has: (gInventory indexOf: curInvIcon))
				(= temp3
					(+
						(/
							(-
								(- (useIconItem nsRight:) (useIconItem nsLeft:))
								(CelWide
									(curInvIcon view:)
									(+ (curInvIcon loop:) 1)
									(curInvIcon cel:)
								)
							)
							2
						)
						(useIconItem nsLeft:)
					)
				)
				(= temp4
					(+
						y
						(/
							(-
								(- (useIconItem nsBottom:) (useIconItem nsTop:))
								(CelHigh
									(curInvIcon view:)
									(+ (curInvIcon loop:) 1)
									(curInvIcon cel:)
								)
							)
							2
						)
						(useIconItem nsTop:)
					)
				)
				(DrawCel
					(curInvIcon view:)
					(+ (curInvIcon loop:) 1)
					(curInvIcon cel:)
					temp3
					temp4
					-1
				)
				(if (& (useIconItem signal:) $0004)
					(useIconItem mask:)
				)
			else
				(= curInvIcon 0)
			)
		)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
		(self highlight: curIcon)
	)

	(method (hide &tmp temp0 temp1 temp2)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
				(= temp1 (NextNode temp0))
				(if (not (IsObject (= temp2 (NodeValue temp0))))
					(return)
				)
				((= temp2 (NodeValue temp0)) signal: (& (temp2 signal:) $ffdf))
			)
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
			(Graph grREDRAW_BOX y 0 (+ y height) 320)
			(SetPort port)
			(= height activateHeight)
		)
	)

	(method (advance &tmp temp0 temp1)
		(for
			((= temp1 1))
			(<= temp1 size)
			((= temp1 (mod (+ temp1 1) size)))

			(= temp0
				(self at: (mod (+ temp1 (self indexOf: highlightedIcon)) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(if (not (& (temp0 signal:) $0004))
				(break)
			)
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (retreat &tmp temp0 temp1)
		(for
			((= temp1 1))
			(<= temp1 size)
			((= temp1 (mod (+ temp1 1) size)))

			(= temp0
				(self at: (mod (- (self indexOf: highlightedIcon) temp1) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(if (not (& (temp0 signal:) $0004))
				(break)
			)
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (select param1 param2)
		(return
			(if (param1 select: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				1
			else
				0
			)
		)
	)

	(method (highlight param1 param2 &tmp temp0)
		(if (not (& (param1 signal:) $0004))
			(if (IsObject highlightedIcon)
				(highlightedIcon highlight: 0)
			)
			((= highlightedIcon param1) highlight: 1)
		)
		(if (and (>= argc 2) param2)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(param1 nsLeft:)
						(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
					)
					(- (param1 nsBottom:) 3)
			)
		)
	)

	(method (swapCurIcon &tmp temp0)
		(cond
			((& state $0004)
				(return)
			)
			(
				(and
					(!= curIcon (= temp0 (NodeValue (self first:))))
					(not (& (temp0 signal:) $0004))
				)
				(= prevIcon curIcon)
				(= curIcon (NodeValue (self first:)))
			)
			((and prevIcon (not (& (prevIcon signal:) $0004)))
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (curIcon cursor:) 1)
	)

	(method (advanceCurIcon &tmp temp0 temp1 temp2)
		(if (& state $0004)
			(return)
		)
		(= temp0 curIcon)
		(= temp1 0)
		(while
			(&
				((= temp0
						(self at: (mod (+ (self indexOf: temp0) 1) size))
					)
					signal:
				)
				$0006
			)
			(if (> temp1 (+ 1 size))
				(return)
			else
				(++ temp1)
			)
		)
		(= curIcon temp0)
		(gGame setCursor: (curIcon cursor:) 1)
	)

	(method (dispatchEvent param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 50] temp57 temp58 temp59)
		(= temp1 (param1 x:))
		(= temp0 (param1 y:))
		(= temp2 (param1 type:))
		(= temp3 (param1 message:))
		(= temp5 (param1 claimed:))
		(if (= temp4 (self firstTrue: 218 param1))
			(= temp57 (temp4 cursor:))
			(= temp58 (temp4 signal:))
			(= temp59 (== temp4 helpIconItem))
		)
		(param1 dispose:)
		(if (& temp2 $0040)
			(switch temp3
				(3
					(self advance:)
				)
				(7
					(self retreat:)
				)
			)
		else
			(switch temp2
				(0
					(cond
						(
							(not
								(and
									(<= 0 temp0)
									(<= temp0 (+ y height))
									(<= 0 temp1)
									(<= temp1 320)
								)
							)
							(if
								(and
									(& state $0400)
									(or
										(not (IsObject helpIconItem))
										(not (& (helpIconItem signal:) $0010))
									)
								)
								(= oldMouseY 0)
								(= temp5 1)
							)
						)
						((and temp4 (!= temp4 highlightedIcon))
							(= oldMouseY 0)
							(self highlight: temp4)
						)
					)
				)
				(1
					(if (and temp4 (self select: temp4 1))
						(if temp59
							(if temp57
								(gGame setCursor: temp57)
							)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem signal: (| (helpIconItem signal:) $0010))
							)
						else
							(= temp5 (& temp58 $0040))
						)
						(temp4 doit:)
					)
				)
				(4
					(switch temp3
						(27
							(= temp5 1)
						)
						(21248
							(= temp5 1)
						)
						(13
							(if (not temp4)
								(= temp4 highlightedIcon)
							)
							(cond
								((and temp4 (== temp4 helpIconItem))
									(if (!= temp57 -1)
										(gGame setCursor: temp57)
									)
									(if helpIconItem
										(helpIconItem
											signal: (| (helpIconItem signal:) $0010)
										)
									)
								)
								((and (IsObject temp4) (self select: temp4))
									(temp4 doit:)
									(= temp5 (& temp58 $0040))
								)
							)
						)
						(3840
							(self retreat:)
						)
						(9
							(self advance:)
						)
					)
				)
				(24576
					(if (and temp4 (temp4 helpVerb:))
						(= temp6 (GetPort))
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp4 noun:)
								(temp4 helpVerb:)
								0
								1
								0
								0
								(temp4 modNum:)
							init:
						)
						(SetPort temp6)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal:) $ffef))
					)
					(gGame setCursor: 999)
				)
			)
		)
		(return temp5)
	)

	(method (disable param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self at: [param1 temp0])
					)
				)
				(if (!= temp1 (self at: 7))
					(temp1 signal: (| (temp1 signal:) $0004))
					(cond
						((== temp1 curIcon)
							(self advanceCurIcon:)
						)
						((== temp1 highlightedIcon)
							(self advance:)
						)
					)
				)
			)
		else
			(|= state $0004)
		)
	)

	(method (enable param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self at: [param1 temp0])
					)
				)
				(temp1 signal: (& (temp1 signal:) $fffb))
			)
		else
			(&= state $fffb)
		)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (= temp2 0))
		(= temp3 (GetPort))
		(= temp4 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(while (not ((= temp0 (Event new:)) type:))
			(if (not (self isMemberOf: IconBar))
				(temp0 localize:)
			)
			(cond
				((= temp2 (self firstTrue: 218 temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(temp2 modNum:)
							modeless: 1
							init:
						)
						(SetPort temp3)
					)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(gSystemWindow eraseOnly: temp4)
		(gGame setCursor: 999 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(SetPort temp3)
		(if (not (helpIconItem onMe: temp0))
			(self dispatchEvent: temp0)
		else
			(temp0 dispose:)
		)
	)

	(method (findIcon param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (== ((= temp1 (self at: temp0)) message:) param1)
				(return temp1)
			)
		)
		(return 0)
	)
)
