;;; Sierra Script 1.0 - (do not remove this comment)
(script# 13)
(include sci.sh)
(use Main)
(use Print)
(use DCIcon)
(use Cycle)
(use Obj)

(public
	aboutCode 0
)

(local
	theGWalkCursor
	local1
)
(procedure (localproc_052e param1 param2 param3)
	(Print
		sel_198: 2 0 0 param1 param2 0 13
		sel_206: (theIcon1 sel_3: param3 sel_117:)
		sel_110:
	)
)

(instance aboutCode of Code
	(properties
		sel_20 {aboutCode}
	)
	
	(method (sel_57 &tmp [temp0 150] [temp150 150])
		(= theGWalkCursor gWalkCursor)
		(gGame sel_197: 999)
		(Load rsVIEW 993 989)
		(if
			(not
				(Print sel_30: gSel_30 sel_198: 1 0 0 1 0 0 13 sel_110:)
			)
			(self sel_111:)
			(return)
		)
		(if
			(not
				(Print sel_30: gSel_30 sel_198: 1 0 0 2 0 0 13 sel_110:)
			)
			(self sel_111:)
			(return)
		)
		(Message msgGET 13 1 0 0 3 @temp0)
		(Format
			@temp150
			@temp0
			global112
			global113
			global114
			global27
		)
		(if (not (Print sel_198: @temp150 sel_110:))
			(self sel_111:)
			(return)
		)
		(if (not (Print sel_198: 1 0 0 4 0 0 13 sel_110:))
			(self sel_111:)
			(return)
		)
		(if (not (Print sel_198: 2 0 0 1 0 0 13 sel_110:))
			(self sel_111:)
			(return)
		)
		(if (not (Print sel_198: 2 0 0 2 0 0 13 sel_110:))
			(self sel_111:)
			(return)
		)
		(= local1 1)
		(if
			(not
				(Print
					sel_198: 2 0 0 3 0 0 13
					sel_206: (theIcon1 sel_2: 993 sel_3: 0 sel_117:) 0 0 0 50
					sel_206: (theIcon2 sel_2: 993 sel_3: 1 sel_117:) 0 0 50 50
					sel_206: (theIcon3 sel_2: 993 sel_3: 2 sel_117:) 0 0 75 50
					sel_110:
				)
			)
			(self sel_111:)
			(return)
		)
		(if
			(not
				(Print
					sel_198: 2 0 0 4 0 0 13
					sel_206: theIcon1 0 0 0 50
					sel_206: theIcon2 0 0 50 50
					sel_206: theIcon3 0 0 75 50
					sel_110:
				)
			)
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 5 35 3))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 6 35 3))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 7 35 4))
			(self sel_111:)
			(return)
		)
		(= local1 0)
		(theIcon1 sel_2: 989)
		(if (not (localproc_052e 8 35 1))
			(self sel_111:)
			(return)
		)
		(= local1 1)
		(theIcon1 sel_2: 993)
		(if (not (localproc_052e 9 35 12))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 10 35 5))
			(self sel_111:)
			(return)
		)
		(= local1 0)
		(if (not (localproc_052e 11 45 6 0))
			(self sel_111:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_052e 12 35 7 1))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 13 50 8))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 14 35 9))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 29 35 9))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 15 35 10))
			(self sel_111:)
			(return)
		)
		(= local1 0)
		(theIcon1 sel_2: 989)
		(if (not (localproc_052e 16 50 0))
			(self sel_111:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_052e 17 35 1))
			(self sel_111:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_052e 30 35 1))
			(self sel_111:)
			(return)
		)
		(if
			(not
				(Print
					sel_198: 2 0 0 18 40 0 13
					sel_206: (theIcon1 sel_2: 989 sel_3: 2 sel_117:) 0 0 0 0
					sel_206: (theIcon2 sel_2: 989 sel_3: 3 sel_117:) 0 0 130 0
					sel_110:
				)
			)
			(self sel_111:)
			(return)
		)
		(= local1 0)
		(if
			(not
				(Print
					sel_198: 2 0 0 19 0 0 13
					sel_206: (theIcon1 sel_3: 4 sel_117:) 0 0 150 20
					sel_110:
				)
			)
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 20 35 5))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 21 35 6))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 22 35 7))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 23 35 8))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 24 75 9))
			(self sel_111:)
			(return)
		)
		(theIcon1 sel_2: 993)
		(= local1 1)
		(if (not (localproc_052e 25 55 4))
			(self sel_111:)
			(return)
		)
		(theIcon1 sel_2: 989)
		(= local1 0)
		(if (not (localproc_052e 26 35 10))
			(self sel_111:)
			(return)
		)
		(if (not (localproc_052e 27 35 5))
			(self sel_111:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_052e 28 35 11))
			(self sel_111:)
			(return)
		)
		(self sel_111:)
	)
	
	(method (sel_111)
		(= gWalkCursor theGWalkCursor)
		(gGame sel_197: gWalkCursor)
		(DisposeScript 967)
		(DisposeScript 13)
	)
)

(instance theIcon1 of DCIcon
	(properties
		sel_20 {theIcon1}
		sel_244 15
	)
	
	(method (sel_110)
		(if local1
			((= sel_245 (Fwd sel_109:)) sel_110: self)
		else
			(= sel_4 0)
			((= sel_245 (End sel_109:)) sel_110: self)
		)
	)
)

(instance theIcon2 of DCIcon
	(properties
		sel_20 {theIcon2}
		sel_244 15
	)
	
	(method (sel_110)
		((= sel_245 (Fwd sel_109:)) sel_110: self)
	)
)

(instance theIcon3 of DCIcon
	(properties
		sel_20 {theIcon3}
		sel_244 15
	)
	
	(method (sel_110)
		((= sel_245 (Fwd sel_109:)) sel_110: self)
	)
)
