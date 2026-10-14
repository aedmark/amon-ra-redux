;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use Window)
(use System)

(local
	yesI
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp3 (+ (/ (- (param1 nsRight:) (param1 nsLeft:)) 2) (param1 nsLeft:)))
	(= temp2 param2)
	(while (>= (Abs (- temp2 param3)) 4)
		(if
			(= temp0
				(self
					firstTrue:
						218
						((= temp1 (Event new:))
							x: temp3
							y: temp2
							yourself:
						)
				)
			)
			(temp1 dispose:)
			(return temp0)
		)
		(temp1 dispose:)
		(if (< param2 param3)
			(+= temp2 4)
		else
			(-= temp2 4)
		)
	)
)

(class InvI of IconI
	(properties
		name {InvI}
		view 0
		loop 0
		cel 0
		nsTop 0
		cursor 999
		message 0
		signal 0
		owner 0
		script 0
		value 0
	)

	(method (show &tmp [temp0 4])
		(DrawCel view loop cel nsLeft nsTop -1)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== highlightColor -1)
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (- nsTop 2))
		(= temp1 (- nsLeft 2))
		(= temp2 (+ nsBottom 1))
		(= temp3 (+ nsRight 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 2) (+ nsRight 2) 1)
	)

	(method (onMe param1)
		(return
			(if (super onMe: param1)
				(not (& signal $0004))
			else
				0
			)
		)
	)

	(method (ownedBy param1)
		(return (== owner param1))
	)

	(method (moveTo param1)
		(= owner param1)
		(if (and value (== param1 gEgo))
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)

	(method (doVerb param1)
		(if (not modNum)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun param1 0 1))
			(gMessager say: noun param1 0 0 0 modNum)
		)
	)
)

(class Inv of IconBar
	(properties
		name {Inv}
		normalHeading {You are carrying:}
		heading 0
		empty {nothing!}
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)

	(method (init)
		(= heading normalHeading)
	)

	(method (doit &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8 temp9 [temp10 50])
		(if (gSystemWindow respondsTo: 236)
			(= temp7 (gSystemWindow eraseOnly:))
			(gSystemWindow eraseOnly: 1)
		)
		(while ((= temp1 (Event new:)) type:)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(= temp1 0)
		(while (& state $0020)
			(invEvent
				type: 0
				message: 0
				modifiers: 0
				y: 0
				x: 0
				claimed: 0
				port: 0
			)
			(GetEvent evALL_EVENTS invEvent)
			(= gMouseX (invEvent x:))
			(= gMouseY (invEvent y:))
			(= temp9 0)
			(invEvent localize:)
			(if
				(and
					curIcon
					(not (invEvent modifiers:))
					(!= curIcon selectIcon)
					(or
						(== (invEvent type:) 1)
						(and
							(== (invEvent type:) 4)
							(== (invEvent message:) 13)
							(= temp9 1)
						)
						(and (== (invEvent type:) 256) (= temp9 1))
					)
					(or (!= curIcon helpIconItem) (& (helpIconItem signal:) $0010))
				)
				(invEvent type: 16384 message: (curIcon message:))
			)
			(MapKeyToDir invEvent)
			(= temp2 (invEvent type:))
			(cond
				(gFastCast
					(gFastCast handleEvent: invEvent)
				)
				((and (== temp2 1) (invEvent modifiers:))
					(self advanceCurIcon:)
					(invEvent claimed: 1)
				)
				(
					(and
						(== temp2 0)
						(= temp0 (self firstTrue: 218 invEvent))
						(!= temp0 highlightedIcon)
					)
					(self highlight: temp0)
				)
				(
					(or
						(== temp2 1)
						(and (== temp2 4) (== (invEvent message:) 13))
						(== temp2 256)
					)
					(if
						(and
							(IsObject highlightedIcon)
							(self select: highlightedIcon (== temp2 1))
						)
						(cond
							((== highlightedIcon okButton)
								(break)
							)
							((== highlightedIcon helpIconItem)
								(if (!= (highlightedIcon cursor:) -1)
									(gGame setCursor: (helpIconItem cursor:))
								)
								(cond
									((& state $0800)
										(self noClickHelp:)
									)
									(helpIconItem
										(helpIconItem
											signal: (| (helpIconItem signal:) $0010)
										)
									)
								)
							)
							(else
								(= curIcon highlightedIcon)
								(gGame setCursor: (curIcon cursor:))
							)
						)
					)
				)
				((& temp2 $0040)
					(switch (invEvent message:)
						(3
							(self advance:)
						)
						(7
							(self retreat:)
						)
						(1
							(if
								(and
									highlightedIcon
									(= temp0
										(localproc_0
											highlightedIcon
											(- (highlightedIcon nsTop:) 1)
											0
										)
									)
								)
								(self highlight: temp0 1)
							else
								(self retreat:)
							)
						)
						(5
							(if
								(and
									highlightedIcon
									(= temp0
										(localproc_0
											highlightedIcon
											(+ (highlightedIcon nsBottom:) 1)
											(window bottom:)
										)
									)
								)
								(self highlight: temp0 1)
							else
								(self advance:)
							)
						)
						(0
							(if (& temp2 $0004)
								(self advanceCurIcon:)
							)
						)
					)
				)
				((== temp2 4)
					(switch (invEvent message:)
						(9
							(self advance:)
						)
						(3840
							(self retreat:)
						)
					)
				)
				((and (& temp2 $4000) (= temp0 (self firstTrue: 218 invEvent)))
					(cond
						((& temp2 $2000)
							(if
								(and
									temp0
									(temp0 noun:)
									(Message
										msgGET
										(temp0 modNum:)
										(temp0 noun:)
										(temp0 helpVerb:)
										0
										1
										@temp10
									)
								)
								(if (gSystemWindow respondsTo: 236)
									(= temp6 (gSystemWindow eraseOnly:))
									(gSystemWindow eraseOnly: 1)
									(Prints @temp10)
									(gSystemWindow eraseOnly: temp6)
								else
									(Prints @temp10)
								)
							)
							(helpIconItem signal: (& (helpIconItem signal:) $ffef))
							(gGame setCursor: 999)
						)
						((== temp0 okButton)
							(break)
						)
						((not (temp0 isKindOf: InvI))
							(if (self select: temp0 (not temp9))
								(= curIcon temp0)
								(gGame setCursor: (curIcon cursor:))
								(if (== temp0 helpIconItem)
									(if (& state $0800)
										(self noClickHelp:)
									else
										(helpIconItem
											signal: (| (helpIconItem signal:) $0010)
										)
									)
								)
							)
						)
						(curIcon
							(if (gSystemWindow respondsTo: 236)
								(= temp6 (gSystemWindow eraseOnly:))
								(gSystemWindow eraseOnly: 1)
							)
							(if (curIcon isKindOf: InvI)
								(temp0 doVerb: (curIcon message:))
							else
								(temp0 doVerb: (invEvent message:))
							)
							(if (gSystemWindow respondsTo: 236)
								(gSystemWindow eraseOnly: temp6)
							)
						)
					)
				)
			)
			(invEvent dispose:)
		)
		(invEvent dispose:)
		(if (gSystemWindow respondsTo: 236)
			(gSystemWindow eraseOnly: temp7)
		)
		(self hide:)
	)

	(method (showSelf param1)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: 167))
			(gPMouse stop:)
		)
		(if (gTheIconBar height:)
			(gTheIconBar hide:)
		)
		(if (not window)
			(= window (SysWindow new:))
		)
		(if (window window:)
			(window dispose:)
			(= window 0)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(if (self show: (if argc param1 else gEgo))
			(self doit:)
		)
	)

	(method (show param1 &tmp temp0 temp1)
		(gGame
			setCursor:
				(if curIcon
					(curIcon cursor:)
				else
					(selectIcon cursor:)
				)
		)
		(= temp0 (PicNotValid))
		(PicNotValid 0)
		(|= state $0020)
		(if
			(not
				(= temp1
					(self
						drawInvWindow:
							(if argc param1 else gEgo)
							(gTheIconBar curIcon:)
					)
				)
			)
			(&= state $ffdf)
		)
		(PicNotValid temp0)
		(return temp1)
	)

	(method (hide &tmp temp0)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
		(if window
			(window dispose:)
		)
		(if (and (IsObject curIcon) (curIcon isKindOf: InvI))
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar enable: (gTheIconBar useIconItem:))
			)
			(gTheIconBar
				curIcon:
					((gTheIconBar useIconItem:) cursor: (curIcon cursor:) yourself:)
				curInvIcon: curIcon
			)
			(if (= temp0 ((gTheIconBar curIcon:) cursor:))
				(gGame setCursor: temp0)
			)
		)
	)

	(method (advance param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(for
			((= temp3 (+ temp1 (= temp2 (self indexOf: highlightedIcon)))))
			1
			((++ temp3))

			(= temp0
				(self
					at:
						(if (<= temp3 size)
							temp3
						else
							(mod temp3 (- size 1))
						)
				)
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(if (not (& (temp0 signal:) $0004))
				(break)
			)
		)
		(self highlight: temp0 1)
	)

	(method (retreat param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(for
			((= temp3 (- (= temp2 (self indexOf: highlightedIcon)) temp1)))
			1
			((-- temp3))

			(= temp0 (self at: temp3))
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(if (not (& (temp0 signal:) $0004))
				(break)
			)
		)
		(self highlight: temp0 1)
	)

	(method (ownedBy param1)
		(self firstTrue: 353 param1)
	)

	(method (drawInvWindow param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 [temp22 50])
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if ((= temp9 (NodeValue temp8)) isKindOf: InvI)
				(if (temp9 ownedBy: param1)
					(temp9 signal: (& (temp9 signal:) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 signal: (| (temp9 signal:) $0004))
				)
			else
				(++ temp3)
				(+=
					temp5
					(CelWide (temp9 view:) (temp9 loop:) (temp9 cel:))
				)
				(if
					(>
						(= temp7
							(CelHigh
								(temp9 view:)
								(temp9 loop:)
								(temp9 cel:)
							)
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
		)
		(if (not temp0)
			(Print addTextF: @temp22 {%s %s} normalHeading empty init:)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3)
			(= temp16 3)
		)
		(if (< (* temp16 (= yesI (/ temp0 temp16))) temp0)
			(++ yesI)
		)
		(= temp10 (Max (+ 4 temp5) (* yesI (+ 4 temp2))))
		(= temp12 (/ (- 190 (= temp11 (* temp16 (+ 4 temp1)))) 2))
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= temp21 (self window:))
			(temp21
				top: temp12
				left: temp13
				right: temp15
				bottom: temp14
				open:
			)
		)
		(= temp20 yesI)
		(if temp0
			(= temp18
				(+
					2
					(if (temp21 respondsTo: 385)
						(temp21 yOffset:)
					else
						0
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if (temp21 respondsTo: 384)
							(temp21 xOffset:)
						else
							0
						)
					)
				)
			)
			(for
				((= temp8 (self first:)))
				temp8
				((= temp8 (self next: temp8)))

				(if
					(and
						(not (& ((= temp9 (NodeValue temp8)) signal:) $0004))
						(temp9 isKindOf: InvI)
					)
					(if (not (& (temp9 signal:) $0080))
						(temp9
							nsLeft:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide
													(temp9 view:)
													(temp9 loop:)
													(temp9 cel:)
												)
											)
										)
										2
									)
								)
							nsTop:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh
													(temp9 view:)
													(temp9 loop:)
													(temp9 cel:)
												)
											)
										)
										2
									)
								)
						)
						(temp9
							nsRight: (+ (temp9 nsLeft:) temp6)
							nsBottom: (+ (temp9 nsTop:) temp7)
						)
						(if (-- temp20)
							(+= temp17 temp2)
						else
							(= temp20 yesI)
							(+= temp18 temp1)
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 nsLeft:))
						(= temp18 (temp9 nsTop:))
					)
					(temp9 show:)
					(if (== temp9 param2)
						(temp9 highlight:)
					)
				)
			)
		)
		(= temp17 (/ (- (- (temp21 right:) (temp21 left:)) temp5) 2))
		(= temp11 (- (temp21 bottom:) (temp21 top:)))
		(= temp18 32767)
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if (not ((= temp9 (NodeValue temp8)) isKindOf: InvI))
				(= temp6 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(if (not (& (temp9 signal:) $0080))
					(if (== temp18 32767)
						(= temp18 (- temp11 temp7))
					)
					(temp9
						nsLeft: temp17
						nsTop: temp18
						nsBottom: temp11
						nsRight: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 nsLeft:) temp6))
				(= temp18 (temp9 nsTop:))
				(temp9 signal: (& (temp9 signal:) $fffb) show:)
			)
		)
		(return 1)
	)
)

(instance invEvent of Event
	(properties
		name {invEvent}
	)
)
