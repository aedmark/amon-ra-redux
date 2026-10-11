;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 923)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(class Inset of Code
	(properties
		sel_20 {Inset}
		sel_408 0
		sel_559 0
		sel_28 100
		sel_2 0
		sel_3 0
		sel_4 0
		sel_1 0
		sel_0 0
		sel_60 14
		sel_141 0
		sel_560 0
		sel_143 0
		sel_166 0
		sel_142 0
		sel_561 0
		sel_562 0
		sel_563 0
		sel_564 0
		sel_565 0
		sel_566 0
		sel_567 0
		sel_568 0
		sel_569 0
		sel_365 0
		sel_570 0
		sel_214 -1
		sel_213 0
		sel_571 0
	)

	(method (sel_110 param1 param2 param3)
		(= sel_166 param2)
		(sel_166 sel_365: self)
		(= sel_141 param3)
		(= sel_143 param1)
		(if (and (not sel_408) sel_560)
			(self sel_572: 1)
		)
		(= sel_561 gCast)
		(= sel_562 gFeatures)
		(= sel_563 gAddToPics)
		(= sel_564 gMouseDownHandler)
		(= sel_565 gKeyDownHandler)
		(= sel_566 gDirectionHandler)
		(= sel_567 gWalkHandler)
		(= sel_568 (gCurRoom sel_259:))
		(gCurRoom sel_259: ((List sel_109:) sel_118: sel_117:))
		((= gCast (EventHandler sel_109:)) sel_20: {newCast} sel_118:)
		((= gFeatures (EventHandler sel_109:))
			sel_20: {newFeatures}
			sel_118: self
		)
		((= gAddToPics (EventHandler sel_109:)) sel_20: {newATPs} sel_118:)
		((= gMouseDownHandler (EventHandler sel_109:)) sel_20: {newMH} sel_118: self)
		((= gKeyDownHandler (EventHandler sel_109:)) sel_20: {newKH} sel_118: self)
		((= gDirectionHandler (EventHandler sel_109:)) sel_20: {newDH} sel_118: self)
		((= gWalkHandler (EventHandler sel_109:)) sel_20: {newWH} sel_118:)
		(gTheDoits sel_118: self)
		(self sel_573:)
	)

	(method (sel_57)
		(if sel_142
			(sel_142 sel_57:)
		)
		(if (not sel_560)
			(Animate (sel_561 sel_24:) 0)
		)
	)

	(method (sel_111 param1 &tmp temp0)
		(if sel_365
			(sel_365 sel_111: 0)
		)
		(gFeatures sel_81: self)
		(gMouseDownHandler sel_81: self)
		(gKeyDownHandler sel_81: self)
		(gDirectionHandler sel_81: self)
		(gWalkHandler sel_81: self)
		(gTheDoits sel_81: self)
		(gCast sel_119: 111 sel_119: 81 sel_125: sel_111:)
		(gAddToPics sel_111:)
		(gFeatures sel_111:)
		(gMouseDownHandler sel_111:)
		(gKeyDownHandler sel_111:)
		(gDirectionHandler sel_111:)
		(gWalkHandler sel_111:)
		((gCurRoom sel_259:) sel_111:)
		(sel_166 sel_365: 0)
		(if (== sel_166 gCurRoom)
			(gTheIconBar sel_177: 7)
		)
		(if (or (not argc) param1)
			(self sel_574:)
		)
		(gCurRoom sel_259: sel_568)
		(= gCast sel_561)
		(= gAddToPics sel_563)
		(= gFeatures sel_562)
		(= gMouseDownHandler sel_564)
		(= gKeyDownHandler sel_565)
		(= gDirectionHandler sel_566)
		(= gWalkHandler sel_567)
		(if (or (not argc) param1)
			(gAddToPics sel_57:)
		)
		(if (and (not sel_408) sel_560)
			(self sel_572: 0)
		)
		(if (and (or (not argc) param1) sel_143)
			(= temp0 sel_143)
			(= sel_143 0)
			(temp0 sel_145:)
		)
	)

	(method (sel_146 param1)
		(if (IsObject sel_142)
			(sel_142 sel_111:)
		)
		(= sel_142 (if argc param1 else 0))
		(if sel_142
			(sel_142 sel_110: self &rest)
		)
	)

	(method (sel_133 param1 &tmp [temp0 2])
		(cond
			((and sel_365 (sel_365 sel_133: param1)) 0)
			((& (param1 sel_31:) $4000)
				(cond
					((self sel_218: param1)
						(param1 sel_73: 1)
						(self sel_300: (param1 sel_37:))
					)
					(sel_570
						(param1 sel_73: 1)
						(self sel_111:)
					)
					(else
						(return 0)
					)
				)
			)
		)
	)

	(method (sel_300 param1)
		(if (== sel_214 -1)
			(= sel_214 gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET sel_214 sel_213 param1 0 1))
			(gMessager sel_295: sel_213 param1 0 0 0 sel_214)
		else
			(gDoVerbCode sel_57: param1 self)
		)
	)

	(method (sel_572 param1 &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 (if param1 1000 else -1000))
		(while (< temp0 (gCast sel_86:))
			((gCast sel_64: temp0)
				sel_82: (+ ((gCast sel_64: temp0) sel_82:) temp1)
			)
			(++ temp0)
		)
		(Animate (gCast sel_24:) 0)
	)

	(method (sel_573)
		(if (> sel_408 0)
			(DrawPic
				sel_408
				(if sel_559 100 else sel_28)
				(if sel_559 0 else 1)
				global40
			)
		)
		(if sel_2
			(= sel_571
				((inView sel_109:)
					sel_2: sel_2
					sel_3: sel_3
					sel_4: sel_4
					sel_1: sel_1
					sel_0: sel_0
					sel_63: sel_60
					sel_316: 1
					sel_110:
					sel_117:
				)
			)
		)
	)

	(method (sel_76)
		(self sel_573:)
		(if sel_365
			((sel_365 sel_563:) sel_57:)
			(sel_365 sel_76:)
		)
	)

	(method (sel_574)
		(if sel_2
			(DrawPic (gCurRoom sel_408:) 100)
		else
			(DrawPic (gCurRoom sel_408:) sel_28)
		)
		(gCurRoom sel_28: sel_569)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0 global40)
		)
		(if (gCurRoom sel_365:)
			((gCurRoom sel_365:) sel_76:)
		)
	)

	(method (sel_422 param1 param2 param3)
		(if sel_365
			(sel_365 sel_111:)
		)
		(if (and argc param1)
			(param1
				sel_110:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)

	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1:))
			(= temp1 (param1 sel_0:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(if sel_2
			(return (sel_571 sel_218: param1 param2))
		else
			(return 1)
		)
	)
)

(instance inView of View
	(properties
		sel_20 {inView}
	)

	(method (sel_133)
		(return 0)
	)
)
