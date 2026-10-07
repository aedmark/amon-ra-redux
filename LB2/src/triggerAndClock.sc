;;; Sierra Script 1.0 - (do not remove this comment)
(script# 22)
(include sci.sh)
(use Main)
(use Inset)
(use Sound)
(use View)
(use Obj)

(public
	triggerAndClock 0
)

(local
	local0
	local1
	local2
	[local3 2] = [33 18]
	[local5 5]
)
(instance triggerAndClock of Code
	(properties
		sel_20 {triggerAndClock}
	)
	
	(method (sel_57 param1 param2)
		(if (& param1 $ff00)
			(= local0 (>> (= local0 (& param1 $f000)) $000c))
			(= local1 (>> (= local1 (& param1 $0f00)) $0008))
			(switch (= local2 (+ (* local0 100) (* 15 local1)))
				(815 (proc0_3 1))
				(1015 (proc0_3 2))
				(1115 (proc0_3 3))
				(200 (proc0_3 4))
				(300
					(proc0_3 5)
					(= global111 15)
				)
				(315 (proc0_3 6))
			)
			(global2
				sel_422: clockInset (if (> argc 1) param2 else 0)
			)
			(= param1 (& param1 $00ff))
		)
		(= global124 (+ global124 param1))
	)
)

(instance saveVolume of Code
	(properties
		sel_20 {saveVolume}
	)
	
	(method (sel_57 param1)
		(if (param1 sel_90?)
			(= [local5 (gSounds sel_132: param1)] (param1 sel_94?))
			(if (> [local5 (gSounds sel_132: param1)] 50)
				(param1 sel_172: 50)
			)
		)
	)
)

(instance restoreVolume of Code
	(properties
		sel_20 {restoreVolume}
	)
	
	(method (sel_57 param1 &tmp temp0)
		(if (= temp0 [local5 (gSounds sel_132: param1)])
			(param1 sel_170: temp0 1 5 0)
		)
	)
)

(instance sShowClock of Script
	(properties
		sel_20 {sShowClock}
	)
	
	(method (sel_144 theSel_29 &tmp [temp0 40] temp40)
		(switch (= sel_29 theSel_29)
			(0
				(quarterHand sel_4: local1 sel_110:)
				(hourHand sel_4: local0 sel_110:)
				(gSounds sel_119: 96 saveVolume)
				(= sel_139 60)
			)
			(1
				(clockSound
					sel_40:
					(switch local1
						(0 23)
						(1 20)
						(2 21)
						(3 22)
					)
					sel_39: self
				)
			)
			(2 (= sel_139 60))
			(3
				(gSounds sel_119: 96 restoreVolume)
				(if
					(= temp40
						(switch sel_141
							(1000 -24319)
							(1245 4104)
							(145 8224)
							(245 12290)
							(else  0)
						)
					)
					((ScriptID 90 15)
						sel_162: (ScriptID 90 15) 0 15 0 temp40
					)
				)
				(clockInset sel_111:)
			)
		)
	)
)

(instance quarterHand of View
	(properties
		sel_20 {quarterHand}
		sel_1 33
		sel_0 19
		sel_2 22
		sel_3 2
		sel_60 15
		sel_14 16400
	)
)

(instance hourHand of View
	(properties
		sel_20 {hourHand}
		sel_1 33
		sel_0 19
		sel_2 22
		sel_3 1
		sel_60 15
		sel_14 16400
	)
)

(instance clockInset of Inset
	(properties
		sel_20 {clockInset}
		sel_2 22
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(self sel_146: sShowClock 0 local2)
	)
	
	(method (sel_111)
		(clockSound sel_111:)
		(super sel_111: &rest)
		(switch local2
			(1015
				((ScriptID 90 3) sel_182: -2)
			)
			(1115
				((ScriptID 90 1) sel_618: 440)
				((ScriptID 90 2) sel_618: 520)
				((ScriptID 90 4) sel_182: -1)
			)
			(1245
				((ScriptID 90 6) sel_182: -2)
			)
			(145
				((ScriptID 90 1) sel_618: 520)
				((ScriptID 90 4) sel_618: 430)
			)
			(215
				(if (== ((gInv sel_64: 14) sel_166?) 520)
					((gInv sel_64: 14) sel_166: 630)
				)
			)
			(245
				((ScriptID 90 4) sel_618: 510)
				((ScriptID 90 1) sel_618: 520)
			)
		)
		(if
		(and (proc0_2 1) (gSel_561 sel_122: (ScriptID 35 0)))
			((ScriptID 35 0) sel_111:)
		)
		(if
		(and (proc0_2 2) (gSel_561 sel_122: (ScriptID 90 7)))
			((ScriptID 90 7) sel_619: 0 sel_146: 0 sel_182: -2)
		)
		(if
		(and (proc0_2 3) (gSel_561 sel_122: (ScriptID 90 5)))
			((ScriptID 90 5) sel_619: 0 sel_146: 0 sel_182: -2)
		)
		(if
		(and (proc0_2 5) (gSel_561 sel_122: (ScriptID 90 6)))
			((ScriptID 90 6) sel_619: 0 sel_146: 0 sel_182: -2)
		)
		(if
		(and (proc0_2 6) (gSel_561 sel_122: (ScriptID 90 1)))
			((ScriptID 90 1) sel_619: 0 sel_146: 0 sel_620: -2)
		)
		(DisposeScript 22)
	)
	
	(method (sel_133 param1)
		(param1 sel_73: 1)
		(super sel_133: param1)
	)
)

(instance clockSound of Sound
	(properties
		sel_20 {clockSound}
		sel_99 1
	)
)
