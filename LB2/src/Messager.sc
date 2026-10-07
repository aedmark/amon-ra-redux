;;; Sierra Script 1.0 - (do not remove this comment)
(script# 924)
(include sci.sh)
(use Main)
(use Print)
(use Obj)


(class Messager of Obj
	(properties
		sel_20 {Messager}
		sel_143 0
		sel_290 0
		sel_291 1
		sel_292 0
		sel_293 0
		sel_294 0
	)
	
	(method (sel_111 &tmp theSel_143)
		(if sel_290
			(sel_290 sel_119: 143 0 sel_119: 111 1 sel_111:)
			(= sel_290 0)
		)
		(gIconBar sel_29: sel_294)
		(= sel_294 0)
		(= theSel_143 sel_143)
		(super sel_111:)
		(if theSel_143 (theSel_143 sel_145: sel_293))
	)
	
	(method (sel_145 param1)
		(if (and argc param1) (= sel_293 1))
		(if (or sel_292 sel_293)
			(if gEventHandlerSel_109
				(gEventHandlerSel_109 sel_125: sel_111:)
				(= gEventHandlerSel_109 0)
			)
			(self sel_111:)
		else
			(self sel_296:)
		)
	)
	
	(method (sel_295 param1 theSel_143 param3 param4 theSel_143_2 theTheGSel_40 &tmp theTheSel_143 temp1 temp2 theGSel_40 [temp4 20])
		(= theTheSel_143 (= temp1 (= temp2 0)))
		(= sel_143 (= sel_292 (= sel_293 0)))
		(if (not sel_294) (= sel_294 (gIconBar sel_29?)))
		(if (> argc 5)
			(= theGSel_40 theTheGSel_40)
		else
			(= theGSel_40 gSel_40)
		)
		(if (not sel_290)
			((= sel_290 (Set sel_109:)) sel_118:)
		)
		(if (== param1 -1)
			(if (and (> argc 1) (IsObject theSel_143))
				(= sel_143 theSel_143)
			)
			(self sel_296:)
		else
			(if (and (> argc 4) theSel_143_2)
				(= sel_143 theSel_143_2)
			)
			(if (and (> argc 1) theSel_143)
				(= theTheSel_143 theSel_143)
			)
			(if (and (> argc 2) param3) (= temp1 param3))
			(if (and (> argc 3) param4)
				(= sel_292 1)
				(= temp2 param4)
			else
				(= temp2 1)
			)
			(= sel_143
				(if (and (> argc 4) theSel_143_2) theSel_143_2 else 0)
			)
			(if
				(or
					(and
						(& global90 $0001)
						(Message
							msgGET
							theGSel_40
							param1
							theTheSel_143
							temp1
							temp2
						)
					)
					0
				)
				(self
					sel_296: theGSel_40 param1 theTheSel_143 temp1 temp2
				)
			else
				(Print
					sel_199:
						@temp4
						{<Messager> %d: %d, %d, %d, %d not found}
						theGSel_40
						param1
						theTheSel_143
						temp1
						temp2
					sel_110:
				)
				(self sel_111:)
			)
		)
	)
	
	(method (sel_296 param1 param2 param3 param4 param5 &tmp temp0)
		(if (= temp0 (Message msgNEXT 0))
			(= temp0 (self sel_297: temp0))
			(sel_290 sel_118: temp0)
			(if argc
				(temp0 sel_295: param2 param3 param4 param5 self param1)
			else
				(temp0 sel_295: 0 0 0 0 self)
			)
		else
			(if gEventHandlerSel_109
				(gEventHandlerSel_109 sel_125: sel_111:)
				(= gEventHandlerSel_109 0)
			)
			(self sel_111:)
		)
	)
	
	(method (sel_297)
		(proc921_0 {<Messager findTalker:> Can't find talker})
		(= global4 1)
	)
)
