;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 442)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use System)

(public
	sOHMeeting 0
	sOHNoMeet 1
	sOHLeave 2
)

(local
	local0
)

(instance sOHMeeting of Script
	(properties
		sel_20 {sOHMeeting}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				((ScriptID 32 0) ; aHeimlich
					sel_110:
					sel_2: 814
					sel_3: 1
					sel_63: 9
					sel_1: 225
					sel_0: 138
					sel_620: 440
				)
				(= sel_136 1)
			)
			(2
				((ScriptID 32 0) sel_63: 9 sel_312: MoveTo 189 145 self) ; aHeimlich
			)
			(3
				((ScriptID 32 0) sel_63: -1 sel_312: MoveTo 127 154 self) ; aHeimlich
			)
			(4
				((ScriptID 90 2) sel_312: PolyPath 124 156 self) ; aOlympia
				((ScriptID 32 0) sel_312: MoveTo 86 159 self) ; aHeimlich
			)
			(5 0)
			(6
				(Face (ScriptID 32 0) (ScriptID 90 2)) ; aHeimlich, aOlympia
				(= sel_136 5)
			)
			(7
				(gMessager sel_295: 2 0 3 0 self 1440)
			)
			(8
				(self sel_111:)
			)
		)
	)
)

(instance sOHNoMeet of Script
	(properties
		sel_20 {sOHNoMeet}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveTo 98 161 self)
			)
			(2
				((ScriptID 32 0) ; aHeimlich
					sel_110:
					sel_2: 814
					sel_63: 9
					sel_1: 225
					sel_0: 138
					sel_620: 440
				)
				(Face gEgo (ScriptID 32 0)) ; aHeimlich
				(= sel_136 1)
			)
			(3
				((ScriptID 32 0) sel_63: 9 sel_312: MoveTo 189 145 self) ; aHeimlich
			)
			(4
				((ScriptID 32 0) sel_63: -1 sel_312: MoveTo 127 154 self) ; aHeimlich
			)
			(5
				((ScriptID 90 2) sel_312: PolyPath 176 150 self) ; aOlympia
			)
			(6
				(self sel_111:)
			)
		)
	)
)

(instance sOHLeave of Script
	(properties
		sel_20 {sOHLeave}
	)

	(method (sel_57)
		(if
			(and
				(== (self sel_29:) 3)
				(not ((ScriptID 90 2) sel_56:)) ; aOlympia
				(not ((ScriptID 32 0) sel_56:)) ; aHeimlich
				(not local0)
			)
			(= local0 1)
			(self sel_145:)
		)
		(super sel_57:)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 3)
			)
			(1
				((ScriptID 90 2) sel_312: PolyPath 228 133 sOHLeave) ; aOlympia
				((ScriptID 32 0) sel_63: -1 sel_312: MoveTo 189 145 self) ; aHeimlich
			)
			(2
				((ScriptID 32 0) sel_63: 9 sel_312: MoveTo 230 138 self) ; aHeimlich
			)
			(3 0)
			(4
				(= sel_137 1)
			)
			(5
				((ScriptID 32 0) sel_111:) ; aHeimlich
				(self sel_111:)
			)
		)
	)
)
