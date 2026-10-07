;;; Sierra Script 1.0 - (do not remove this comment)
(script# 932)
(include sci.sh)
(use Main)
(use Print)

(public
	proc932_0 0
	proc932_1 1
	proc932_2 2
	proc932_3 3
	proc932_4 4
	proc932_5 5
	proc932_6 6
	proc932_7 7
)

(local
	theGGameSel_85
	local1
)
(procedure (proc932_0)
	(localproc_0028 0 &rest)
)

(procedure (proc932_1)
	(localproc_0028 1 &rest)
)

(procedure (proc932_2 param1 param2 param3 param4)
	(return
		(cond 
			((== (gGame sel_84?) 1)
				(if (or (< argc 3) (== (gGame sel_85?) 0))
					param1
				else
					param3
				)
			)
			((or (< argc 4) (== (gGame sel_85?) 0)) param2)
			(else param4)
		)
	)
)

(procedure (proc932_3 &tmp gGameSel_85)
	(if
		(and
			(not theGGameSel_85)
			(= gGameSel_85 (gGame sel_85?))
		)
		(= theGGameSel_85 gGameSel_85)
		(gGame sel_85: 0)
	)
	(return gGameSel_85)
)

(procedure (proc932_4 &tmp theTheGGameSel_85)
	(if
		(and
			(= theTheGGameSel_85 theGGameSel_85)
			(not (gGame sel_85?))
		)
		(gGame sel_85: theGGameSel_85)
		(= theGGameSel_85 0)
	)
	(return theTheGGameSel_85)
)

(procedure (proc932_5 &tmp gGameSel_85)
	(return
		(if (= gGameSel_85 (gGame sel_85?))
			(gGame sel_85: (gGame sel_84?))
			(gGame sel_84: gGameSel_85)
			(return 1)
		else
			0
		)
	)
)

(procedure (proc932_6 param1 param2 param3 param4 &tmp gGameSel_84 gGameSel_85 temp2 [temp3 1000])
	(if (== argc 4)
		(GetFarText @temp3 param3 param4)
	else
		(StrCpy @temp3 param3)
	)
	(= gGameSel_84 (gGame sel_84?))
	(= gGameSel_85 (gGame sel_85?))
	(gGame sel_84: 1 sel_85: 0)
	(StrSplit param1 @temp3 0)
	(if (= temp2 0)
		(gGame sel_84: temp2)
		(StrSplit param2 @temp3 0)
	else
		(StrCpy param2 {})
	)
	(gGame sel_84: gGameSel_84 sel_85: gGameSel_85)
	(return param1)
)

(procedure (proc932_7 param1 param2)
	(return (if (== (gGame sel_83?) 1) param1 else param2))
)

(procedure (localproc_0028 param1 &tmp gGameSel_84 gGameSel_85)
	(= gGameSel_85 (gGame sel_85?))
	(gGame sel_85: 0)
	(if param1 (Display &rest) else (proc921_0 &rest 124))
	(if gGameSel_85
		(= gGameSel_84 (gGame sel_84?))
		(gGame sel_84: gGameSel_85)
		(if param1 (Display &rest) else (proc921_0 &rest))
		(gGame sel_84: gGameSel_84)
	)
	(gGame sel_85: gGameSel_85)
)
