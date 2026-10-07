;;; Sierra Script 1.0 - (do not remove this comment)
(script# 100)
(include sci.sh)
(use Main)
(use LBRoom)
(use RTRandCycle)
(use CueObj)
(use n958)
(use DPath)
(use Cycle)
(use View)
(use Obj)

(public
	rm100 0
)

(local
	theFPlay
	local1
	local2
	local3
	local4
)
(procedure (localproc_0333 param1 param2 &tmp temp0)
	(= temp0 (if param2 global157 else global162))
	(switch param1
		(fIntro
			(Display
				(proc0_11
					{EINLEITUNG}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
				)
				100
				(proc0_11 196 187 187 187 187)
				103
				105
				61
				102
				global151
			)
			(Display
				(proc0_11
					{EINLEITUNG}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
					{INTRODUCTION}
				)
				100
				(proc0_11 196 187 187 187 187)
				103
				105
				60
				102
				temp0
			)
		)
		(fPlay
			(Display
				(proc0_11
					{SPIELSTART}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
				)
				100
				(proc0_11 197 200 200 200 200)
				113
				105
				61
				102
				global151
			)
			(Display
				(proc0_11
					{SPIELSTART}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
					{PLAY GAME}
				)
				100
				(proc0_11 197 200 200 200 200)
				113
				105
				60
				102
				temp0
			)
		)
		(fContinue
			(Display
				(proc0_11
					{LADEN}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
				)
				100
				(proc0_11 216 170 170 170 170)
				123
				105
				61
				102
				global151
			)
			(Display
				(proc0_11
					{LADEN}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
					{CONTINUE SAVED GAME}
				)
				100
				(proc0_11 216 170 170 170 170)
				123
				105
				60
				102
				temp0
			)
		)
		(fQuit
			(Display
				(proc0_11 {ENDE} {QUIT} {QUIT} {QUIT} {QUIT})
				100
				220
				133
				105
				61
				102
				global151
			)
			(Display
				(proc0_11 {ENDE} {QUIT} {QUIT} {QUIT} {QUIT})
				100
				220
				133
				105
				60
				102
				temp0
			)
		)
	)
)

(instance rm100 of LBRoom
	(properties
		sel_20 {rm100}
		sel_408 100
	)
	
	(method (sel_110)
		(proc958_0 128 108 151 101)
		(proc958_0 132 100 20 23)
		(proc958_0 130 964)
		(self sel_414: 92)
		(Palette palSET_INTENSITY 0 255 0)
		(super sel_110:)
		(gIconBar sel_233:)
		(= local1 (Graph grSAVE_BOX 99 185 142 319 1))
		(= local2 (Graph grSAVE_BOX 123 151 133 185 1))
		(gLb2MDH sel_129: self)
		(gLb2KDH sel_129: self)
		(gLb2DH sel_129: self)
		(lauraBowTitle sel_110:)
		(fIntro sel_110:)
		(fPlay sel_110:)
		(fContinue sel_110:)
		(fQuit sel_110:)
		(self sel_146: sStart)
	)
	
	(method (sel_57 &tmp theTheFPlay)
		(super sel_57:)
		(if sel_142
		else
			(= theTheFPlay
				(gSel_562 sel_120: 218 gSel_1 (- gSel_0 10))
			)
			(if
			(and (IsObject theTheFPlay) (!= theTheFPlay theFPlay))
				(localproc_0333 theFPlay 0)
				(localproc_0333 theTheFPlay 1)
				(= theFPlay theTheFPlay)
			)
		)
	)
	
	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(= temp1 (param1 sel_31?))
		(= temp0 (param1 sel_37?))
		(cond 
			(
				(or
					(and (== temp1 1) (not (param1 sel_61?)))
					(and (== temp1 4) (== temp0 13))
				)
				(param1 sel_73: 1)
				(switch theFPlay
					(fIntro
						(Graph grRESTORE_BOX local1)
						(Graph grRESTORE_BOX local2)
						(Graph grUPDATE_BOX 99 185 142 319 1)
						(Graph grUPDATE_BOX 123 151 133 185 1)
						(global2 sel_146: sCartoon)
					)
					(fPlay
						(gEgo sel_350: -1 2)
						(global2 sel_146: sCartoon)
					)
					(fContinue
						(gGame sel_76:)
						(localproc_0333 fIntro 0)
						(localproc_0333 fPlay 0)
						(localproc_0333 fContinue 0)
						(localproc_0333 fQuit 0)
						(gLb2MDH sel_129: self)
						(gLb2KDH sel_129: self)
						(gLb2DH sel_129: self)
					)
					(fQuit (= global4 1))
				)
			)
			((not (& temp1 $0040)))
			((== temp0 1)
				(localproc_0333 theFPlay 0)
				(if
				(>= (= temp2 (- (gSel_562 sel_132: theFPlay) 1)) 0)
					(= theFPlay (gSel_562 sel_64: temp2))
				else
					(= theFPlay
						(gSel_562 sel_64: (- (gSel_562 sel_86?) 1))
					)
				)
				(localproc_0333 theFPlay 1)
			)
			((== temp0 5)
				(localproc_0333 theFPlay 0)
				(if
					(<
						(= temp2 (+ (gSel_562 sel_132: theFPlay) 1))
						(gSel_562 sel_86?)
					)
					(= theFPlay (gSel_562 sel_64: temp2))
				else
					(= theFPlay (gSel_562 sel_64: 0))
				)
				(localproc_0333 theFPlay 1)
			)
		)
	)
	
	(method (sel_399)
		(gLb2MDH sel_81: self)
		(gLb2KDH sel_81: self)
		(gLb2DH sel_81: self)
		(gUser sel_347: 0 sel_237: 0)
		(super sel_399: &rest)
	)
)

(instance sStart of Script
	(properties
		sel_20 {sStart}
	)
	
	(method (sel_57)
		(if (< local3 100)
			(Palette palSET_INTENSITY 0 255 (++ local3))
			(if (== local3 100) (self sel_145:))
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 0)
			(1
				(gGame sel_197: 996)
				(gUser sel_347: 1 sel_237: 1)
				(gSel_608 sel_40: 20 sel_99: 1 sel_39:)
				(localproc_0333 fIntro 0)
				(= sel_139 40)
			)
			(2
				(localproc_0333 fPlay 0)
				(= sel_139 40)
			)
			(3
				(localproc_0333 fContinue 0)
				(= sel_139 40)
			)
			(4
				(localproc_0333 fQuit 0)
				(= sel_139 120)
			)
			(5
				(gSel_608 sel_40: 23 sel_99: 1 sel_39:)
				(localproc_0333 fPlay 1)
				(= theFPlay fPlay)
				(gGame sel_197: 999)
				(self sel_111:)
			)
		)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)
	
	(method (sel_57)
		(if (and local4 local3)
			(Palette palSET_INTENSITY 0 255 (-- local3))
			(if (not local3) (self sel_145:))
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (== theFPlay fPlay)
					(self sel_144: 18)
				else
					(sparkle sel_110:)
					(wake sel_110: sel_161: RTRandCycle)
					(smoke sel_110: sel_161: RTRandCycle)
					(gSel_608 sel_40: 100 sel_3: 1 sel_99: 1 sel_39: self)
					(gGame sel_587: sel_197: 996 1 304 172)
					(= sel_137 3)
				)
			)
			(1
				(sparkle
					sel_155: 2
					sel_161: Fwd
					sel_312:
						DPath
						17
						93
						39
						91
						55
						95
						116
						115
						138
						117
						160
						113
						167
						101
						161
						94
						self
				)
			)
			(2
				(sparkle sel_155: 3 sel_156: 0 sel_161: End self)
			)
			(3
				(sparkle
					sel_155: 2
					sel_156: 0
					sel_153: 84 27
					sel_161: End self
				)
			)
			(4
				(sparkle
					sel_332: -32768
					sel_155: 2
					sel_156: 0
					sel_153: 66 153
					sel_161: End self
				)
			)
			(5 (= sel_137 4))
			(6
				(lauraBowTitle sel_111:)
				(sparkle sel_111:)
				(creditTitle sel_110: sel_312: MoveTo 12 102 self)
				(creditName sel_110: sel_312: MoveTo 164 128 self)
			)
			(7 0)
			(8 (= sel_137 4))
			(9
				(creditTitle sel_312: MoveTo -222 102 self)
				(creditName sel_312: MoveTo 398 128 self)
			)
			(10 0)
			(11 (= sel_137 3))
			(12
				(creditTitle
					sel_110:
					sel_3: 1
					sel_312: MoveTo 12 102 self
				)
				(creditName
					sel_110:
					sel_3: 1
					sel_312: MoveTo 164 128 self
				)
			)
			(13 0)
			(14 (= sel_137 4))
			(15
				(creditTitle sel_312: MoveTo 12 210 self)
				(creditName sel_312: MoveTo 164 236 self)
			)
			(16 0)
			(17 0)
			(18 (= local4 1))
			(19
				(global2 sel_399: (if (== theFPlay fPlay) 26 else 110))
			)
		)
	)
)

(instance fIntro of Feature
	(properties
		sel_20 {fIntro}
		sel_1 263
		sel_0 104
		sel_6 103
		sel_7 208
		sel_8 113
		sel_9 318
	)
)

(instance fPlay of Feature
	(properties
		sel_20 {fPlay}
		sel_1 263
		sel_0 104
		sel_6 113
		sel_7 208
		sel_8 123
		sel_9 318
	)
)

(instance fContinue of Feature
	(properties
		sel_20 {fContinue}
		sel_1 263
		sel_0 104
		sel_6 123
		sel_7 208
		sel_8 133
		sel_9 318
	)
)

(instance fQuit of Feature
	(properties
		sel_20 {fQuit}
		sel_1 263
		sel_0 104
		sel_6 133
		sel_7 208
		sel_8 143
		sel_9 318
	)
)

(instance lauraBowTitle of View
	(properties
		sel_20 {lauraBowTitle}
		sel_0 156
		sel_2 101
	)
)

(instance smoke of Prop
	(properties
		sel_20 {smoke}
		sel_1 204
		sel_0 59
		sel_2 101
		sel_3 1
		sel_244 20
	)
)

(instance wake of Prop
	(properties
		sel_20 {wake}
		sel_1 230
		sel_0 91
		sel_2 101
		sel_3 2
		sel_244 20
	)
)

(instance creditTitle of Actor
	(properties
		sel_20 {creditTitle}
		sel_1 12
		sel_0 190
		sel_2 151
		sel_14 2048
		sel_53 0
	)
)

(instance creditName of Actor
	(properties
		sel_20 {creditName}
		sel_1 164
		sel_0 216
		sel_2 151
		sel_4 1
		sel_14 2048
		sel_53 0
	)
)

(instance sparkle of Actor
	(properties
		sel_20 {sparkle}
		sel_0 100
		sel_2 108
		sel_3 2
		sel_60 15
		sel_14 16400
		sel_244 4
		sel_53 4
	)
)
