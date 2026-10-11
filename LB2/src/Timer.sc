;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 973)
(include sci.sh)
(use Main)
(use System)

(class Timer of Obj
	(properties
		sel_20 {Timer}
		sel_158 -1
		sel_137 -1
		sel_139 -1
		sel_159 -1
		sel_42 0
	)

	(procedure (CueClient &tmp who)
		(= who sel_42)
		(= sel_42 0)
		(if (IsObject who)
			(if (who sel_116: 135)
				(who sel_135: 0)
			)
			(if (who sel_116: 145)
				(who sel_145:)
			)
		)
	)

	(method (sel_109)
		(return
			(if (== self Timer)
				(super sel_109:)
			else
				self
			)
		)
	)

	(method (sel_110 param1)
		(= sel_42 param1)
		(gTimers sel_118: self)
		(if (param1 sel_116: 135)
			(if (IsObject (param1 sel_135:))
				((param1 sel_135:) sel_111:)
			)
			(param1 sel_135: self)
		)
	)

	(method (sel_57 &tmp temp0)
		(cond
			((!= sel_158 -1)
				(if (not (-- sel_158))
					(CueClient)
				)
			)
			((!= sel_137 -1)
				(if (!= sel_159 (= temp0 (GetTime 1))) ; SysTime12
					(= sel_159 temp0)
					(if (not (-- sel_137))
						(CueClient)
					)
				)
			)
			((> (- gGameTime sel_139) 0)
				(CueClient)
			)
		)
	)

	(method (sel_111)
		(if (and (IsObject sel_42) (sel_42 sel_116: 135))
			(sel_42 sel_135: 0)
		)
		(= sel_42 0)
	)

	(method (sel_160 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(if (== (= temp2 gSpeed) 0)
			(= temp2 1)
		)
		(= temp1 (/ (* param2 60) temp2))
		(if (> argc 2)
			(+= temp1 (/ (* param3 3600) temp2))
		)
		(if (> argc 3)
			(+= temp1 (* (/ (* param4 3600) temp2) 60))
		)
		((= temp0
				(if (& -info- $8000)
					(self sel_109:)
				else
					self
				)
			)
			sel_110: param1
			sel_158: temp1
		)
		(return temp0)
	)

	(method (sel_161 param1 param2 &tmp temp0)
		((= temp0
				(if (& -info- $8000)
					(self sel_109:)
				else
					self
				)
			)
			sel_110: param1
			sel_158: param2
		)
		(return temp0)
	)

	(method (sel_162 param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp1 param2)
		(if (> argc 2)
			(+= temp1 (* param3 60))
		)
		(if (> argc 3)
			(+= temp1 (* param4 3600))
		)
		((= temp0
				(if (& -info- $8000)
					(self sel_109:)
				else
					self
				)
			)
			sel_110: param1
			sel_137: temp1
		)
		(return temp0)
	)

	(method (sel_81)
		(if (== sel_42 0)
			(gTimers sel_81: self)
			(super sel_111:)
		)
	)

	(method (sel_163 param1 param2 &tmp temp0)
		(= temp0
			(if (& -info- $8000)
				(self sel_109:)
			else
				self
			)
		)
		(temp0 sel_139: (+ gGameTime param1) sel_110: param2)
		(return temp0)
	)
)

(class TO of Obj
	(properties
		sel_20 {TO}
		sel_164 0
	)

	(method (sel_57)
		(if sel_164
			(-- sel_164)
		)
	)

	(method (sel_160 param1)
		(= sel_164 param1)
	)
)
