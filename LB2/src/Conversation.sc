;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 925)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class MessageObj of Obj
	(properties
		name {MessageObj}
		modNum -1
		noun 0
		verb 0
		case 0
		sequence 0
		whoSays 0
		client 0
		caller 0
		font 0
		x 0
		y 0
	)

	(method (showSelf &tmp [temp0 40])
		(= whoSays
			(gMessager
				findTalker:
					(Message
						msgGET
						modNum
						noun
						verb
						case
						(if sequence sequence else 1)
					)
			)
		)
		(if (not (IsObject whoSays))
			(Print
				addTextF:
					@temp0
					{<MessageObj> Message not found: %d - %d, %d, %d, %d}
					modNum
					noun
					verb
					case
					sequence
				init:
			)
			(= gQuit 1)
		else
			(if font
				(whoSays font: font)
			)
			(if (or x y)
				(whoSays x: x y: y)
			)
			(gMessager say: noun verb case sequence caller modNum)
		)
	)
)

(class Conversation of List
	(properties
		name {Conversation}
		script 0
		curItem -1
		caller 0
	)

	(method (init param1)
		(= curItem -1)
		(if (and argc (IsObject param1))
			(= caller param1)
		)
		(gTheDoits add: self)
		(self cue:)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose &tmp temp0)
		(self eachElementDo: 96 cleanCode)
		(gTheDoits delete: self)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if script
			(= script 0)
		)
		(= temp0 caller)
		(super dispose:)
		(if temp0
			(temp0 cue:)
		)
	)

	(method (add param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 0)))))
		(= temp5 (= temp6 (= temp7 0)))
		(if (and argc (not (IsObject param1)))
			(if (== (= temp0 param1) -1)
				(= temp0 gCurRoomNum)
			)
			(if (> argc 1)
				(= temp1 param2)
				(if (> argc 2)
					(= temp2 param3)
					(if (> argc 3)
						(= temp3 param4)
						(if (> argc 4)
							(= temp4 param5)
							(if (> argc 5)
								(= temp5 param6)
								(if (> argc 6)
									(= temp6 param7)
									(if (> argc 7)
										(= temp7 param8)
									)
								)
							)
						)
					)
				)
			)
			(if (not (IsObject param1))
				(super
					add:
						((MessageObj new:)
							modNum: temp0
							noun: temp1
							verb: temp2
							case: temp3
							sequence: temp4
							x: temp5
							y: temp6
							font: temp7
							yourself:
						)
				)
			)
		else
			(super add: param1 &rest)
		)
	)

	(method (cue param1 &tmp temp0 temp1)
		(if (or (and argc param1) (== (++ curItem) size))
			(self dispose:)
		else
			(= temp0 (self at: curItem))
			(cond
				((temp0 isKindOf: MessageObj)
					(temp0 caller: self showSelf:)
				)
				((temp0 isKindOf: Script)
					(self setScript: temp0 self)
				)
				((IsObject temp0)
					(temp0 doit: self)
				)
				(else
					(self cue:)
				)
			)
		)
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (load param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp0 (WordAt param1 0))
		(= temp1 (WordAt param1 1))
		(= temp2 (WordAt param1 2))
		(= temp3 (WordAt param1 3))
		(= temp4 (WordAt param1 4))
		(= temp5 (WordAt param1 5))
		(= temp6 (WordAt param1 6))
		(= temp7 (WordAt param1 7))
		(= temp8 7)
		(while temp0
			(if (== temp0 -1)
				(= temp0 gCurRoomNum)
			)
			(self add: temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
			(= temp0 (WordAt param1 (++ temp8)))
			(= temp1 (WordAt param1 (++ temp8)))
			(= temp2 (WordAt param1 (++ temp8)))
			(= temp3 (WordAt param1 (++ temp8)))
			(= temp4 (WordAt param1 (++ temp8)))
			(= temp5 (WordAt param1 (++ temp8)))
			(= temp6 (WordAt param1 (++ temp8)))
			(= temp7 (WordAt param1 (++ temp8)))
		)
	)
)

(instance cleanCode of Code
	(properties
		name {cleanCode}
	)

	(method (doit param1 &tmp temp0)
		(if (param1 isKindOf: Script)
			(param1 caller: 0)
		)
		(if
			(and
				(param1 isKindOf: MessageObj)
				(IsObject (= temp0 (param1 whoSays:)))
				(temp0 underBits:)
			)
			(temp0 dispose: 1)
		)
	)
)
